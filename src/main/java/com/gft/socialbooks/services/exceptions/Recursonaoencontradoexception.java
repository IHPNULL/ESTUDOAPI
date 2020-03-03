package com.gft.socialbooks.services.exceptions;

public class Recursonaoencontradoexception extends RuntimeException {

  private static final long serialVersionUID = -8982650449879918484L;

  public Recursonaoencontradoexception(String message) {
    super(message);
  }

  public Recursonaoencontradoexception(String message, Throwable cause) {
    super(message, cause);
  }

}
