package com.gft.socialbooks.services.exceptions;

public class Livronaoencontradoexception extends RuntimeException {
	
	
	public Livronaoencontradoexception(String mensagem) {
		super(mensagem);
	}
	
	public Livronaoencontradoexception(String mensagem, Throwable causa) {
		super(mensagem,causa);
	}
	
}
