package com.gft.socialbooks.services.exceptions;

public class Recursoexistenteexception extends RuntimeException {

  private static final long serialVersionUID = 3102285043620313882L;

  public Recursoexistenteexception(String message) {
    super(message);
  }

  public Recursoexistenteexception(String message, Throwable cause) {
    super(message, cause);
  }

}
