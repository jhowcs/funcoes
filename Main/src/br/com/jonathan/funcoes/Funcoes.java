package br.com.jonathan.funcoes;

import javax.management.AttributeNotFoundException;

public class Funcoes {
	/**
	 * Método responsável por quebrar uma String em várias linhas.
	 *
	 * @param texto
	 *            - Texto á ser quebrado em várias linhas a quantidade máxima de caracteres por linha default é 45.
	 * @return StringBuilder com o texto quebrado em várias linhas
	 * 
	 * @since 23/04/2015
	 */
	public static StringBuilder quebrarTexto(String texto) throws AttributeNotFoundException {
		return quebrarTexto(texto, 45);
	}
	
	/**
	 * Método responsável por quebrar uma String em várias linhas com o máximo
	 * de caracteres especificados no parâmetro.
	 *
	 * @param texto
	 *            - Texto á ser quebrado em várias linhas
	 * @param maxCharLinha
	 *            - Quantidade máxima, deve ser maior ou igual a 2
	 * @return StringBuilder com o texto quebrado em várias linhas
	 * 
	 * @since 19/04/2015
	 */
	public static StringBuilder quebrarTexto(String texto, int maxCharLinha) throws AttributeNotFoundException {
		if(maxCharLinha < 2)
			throw new AttributeNotFoundException("O parâmetro maxCharLinha deve ser maior ou igual a 2!!!");
		
		StringBuilder sbTexto = new StringBuilder();

		if (texto != null && texto.length() > 0) {
			// Remove caracteres em branco duplicados
			final String str = texto.replaceAll("\\s+", " ").trim();

			// Array com todas as palavras encontratas no parametro texto
			final String[] arrayStr = str.split("\\s");

			int contChar = 0;

			for (int i = 0; i < arrayStr.length; i++) {
				contChar += arrayStr[i].length();

				if (contChar <= maxCharLinha) {
					sbTexto.append(arrayStr[i]);
				} else {
					contChar = arrayStr[i].length();

					if (contChar > maxCharLinha) {
						int iniCopia = 0;			
						while (iniCopia < (contChar - (maxCharLinha-1))) {
							sbTexto.append("\n");
												
							sbTexto.append(arrayStr[i].substring(iniCopia, iniCopia + (maxCharLinha-1)));
						
							
							iniCopia += maxCharLinha - 1;
							
							if(iniCopia < (contChar))
								sbTexto.append("-");
						}
						sbTexto.append("\n");
						sbTexto.append(arrayStr[i].substring(iniCopia, contChar));
					} else {

						sbTexto.append("\n");
						sbTexto.append(arrayStr[i]);
					}
				}
				sbTexto.append(" ");
				contChar += 1;
			}
		}

		return sbTexto;
	}
}
