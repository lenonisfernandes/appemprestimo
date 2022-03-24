package br.edu.infnet.dashboard.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Emprestimo;
import br.edu.infnet.dashboard.model.domain.Log;
import br.edu.infnet.dashboard.model.domain.Material;
import br.edu.infnet.dashboard.model.service.EmprestimoService;
import br.edu.infnet.dashboard.model.service.LogService;

@Controller
public class RelatorioController {
	
	@Autowired 
	private EmprestimoService emprestimoService;
	
	@Autowired
	private LogService logService;
	
	@GetMapping(value="/generate")
	public String emissaoRelatorio(Model model) {
		
		Workbook workbook = new XSSFWorkbook();
		
		Sheet sheet = workbook.createSheet("Materiais");
		
		Row headerRow = sheet.createRow(0);
		
		String[] columns = {"Data", "Descrição", "Tipo", 
				"Nome do Cliente", "Email do Cliente", "CPF do Cliente", "UF do Cliente", 
				"Titulo do Material", "Autor do Material"};
		
		for(int i=0; i < columns.length; i++) {
			//Cell cell = headerRow.createCell(i);
			//cell.setCellValue(columns[i]);
			headerRow.createCell(i).setCellValue(columns[i]);
		}
		
		int rowNum=0;
		
		List<Emprestimo> emprestimos = emprestimoService.obterLista();
		
		for(Emprestimo e : emprestimos) {
			for (Material p : e.getMateriais()) {
				Row row = sheet.createRow(++rowNum);
				
				row.createCell(0).setCellValue(e.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm")));
				row.createCell(1).setCellValue(e.getDescricao());
				row.createCell(2).setCellValue(e.isWeb() ? "web" : "campus");
				row.createCell(3).setCellValue(e.getCliente().getNome());
				row.createCell(4).setCellValue(e.getCliente().getEmail());
				row.createCell(5).setCellValue(e.getCliente().getCpf());
				row.createCell(6).setCellValue(e.getCliente().getEndereco().getUf());
				row.createCell(7).setCellValue(p.getTitulo());
				row.createCell(8).setCellValue(p.getAutor());
			}
		}
		
		LocalDateTime hoje = LocalDateTime.now();
		String arquivo = "materiais"+hoje.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))+".xlsx";
		String mensagem = null;
		
		try {
			workbook.write(new FileOutputStream(arquivo));
			workbook.close();
			mensagem = "A planilha gerada está no diretório padrão.";
			
		
		} catch (IOException e) {
			mensagem = "Problemas na geração da planilha";
			e.printStackTrace();
		}
		
		Log log = new Log();
		log.setNome(mensagem);
		log.setData(hoje);
		
		logService.incluir(log);
		
		return "redirect:/";
	}

}
