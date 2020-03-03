package com.gft.socialbooks.services.exceptions;

import com.gft.socialbooks.services.exceptions.Recursonaoencontradoexception;

public class Autornaoencontradoexception extends Recursonaoencontradoexception {

  private static final long serialVersionUID = -7503198838912178474L;

  public Autornaoencontradoexception(String message) {
    super(message);
  }

  public Autornaoencontradoexception(String message, Throwable cause) {
    super(message, cause);
  }

}
