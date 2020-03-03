package com.gft.socialbooks.services.exceptions;

@SuppressWarnings("serial")
public class Livronaoencontradoexception extends RuntimeException {
	
	
	public Livronaoencontradoexception(String mensagem) {
		super(mensagem);
	}
	
	public Livronaoencontradoexception(String mensagem, Throwable causa) {
		super(mensagem,causa);
	}
	
}
 