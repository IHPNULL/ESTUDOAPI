package com.gft.socialbooks.services.exceptions;

import com.gft.socialbooks.services.exceptions.Recursoexistenteexception;

public class Autorexistenteexception extends Recursoexistenteexception {

  private static final long serialVersionUID = 4069562509345450798L;

  public Autorexistenteexception(String message) {
    super(message);
  }

  public Autorexistenteexception(String message, Throwable cause) {
    super(message, cause);
  }

}
