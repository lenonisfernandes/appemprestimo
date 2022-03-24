package br.edu.infnet.appemprestimo.model.tests;

import br.edu.infnet.appemprestimo.model.domain.Cliente;

public class ClienteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente cliente = new Cliente("Carlos", "carlos@gmail.com", "12345678901");
		
		cliente.setId(1);
				
		System.out.println(cliente.toString());

	}

}
