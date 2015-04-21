package br.com.jonathan.funcoes;

public class Funcoes {

	/**
	 * Método responsável por quebrar uma String em várias linhas com o máximo de caracteres especificados no parâmetro.
	 *
	 * @param texto        - Texto ser quebrado em várias linhas
	 * @param maxCharLinha - Quantidade máxima de caracteres por linha. Default 45
	 * @return StringBuilder com o texto quebrado em várias linhas
	 * 
	 * @since 19/04/2015
	 */
	public static StringBuilder quebrarTexto(String texto, int maxCharLinha) {
		StringBuilder sbTexto = new StringBuilder(); 
	
		if(texto != null && texto.length() > 0) {						
			//Remove caracteres em branco duplicados
			final String str = texto.replaceAll("\\s+", " ").trim();
			
			//Array com todas as palavras encontratas no parametro texto
			final String[] arrayStr   = str.split("\\s");
			
			//Se a quantidade máxima de caracteres por linha informada
			//for 0 então o método assume 45 como default
			maxCharLinha = maxCharLinha > 0 ? maxCharLinha : 45;
			int contChar = 0;
			
			for (int i = 0; i < arrayStr.length; i++) {	
				contChar+= arrayStr[i].length();
				
				if(contChar < maxCharLinha) {
					sbTexto.append(arrayStr[i]);
				} else {
					contChar = arrayStr[i].length();					
					sbTexto.append("\n");
					sbTexto.append(arrayStr[i]);					
				}
				sbTexto.append(" ");
				contChar+= 1;
			}
		}
		
		return sbTexto;
	}
}
