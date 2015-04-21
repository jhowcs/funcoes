package br.com.jonathan.main;

import br.com.jonathan.funcoes.Funcoes;

public class Main {

	public static void main(String[] args) {		
		StringBuilder teste = Funcoes.quebrarTexto(" este e um texto que devera ser       quebrado     em   varias linhas    atraves da funcao criada. ", 15);
		
		
		System.out.println(teste.toString());

	}

}
