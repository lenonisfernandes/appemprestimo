package br.edu.infnet.appemprestimo.model.tests;

import br.edu.infnet.appemprestimo.exceptions.QuantidadeAcademicoAlugadoException;
import br.edu.infnet.appemprestimo.exceptions.QuantidadeAluguelNegativaException;
import br.edu.infnet.appemprestimo.model.domain.*;

public class AcademicoTest {
	
	public static void main(String[] args) {
		
		try {
			Academico academico = new Academico("Titulo", "autor", true);
			academico.setAlugado(-4);
			
			System.out.println(academico.toString()+"; "+academico.restante());
		} catch (QuantidadeAcademicoAlugadoException e) {
			System.out.println(e.getMessage());		
		}

		
	}

}
