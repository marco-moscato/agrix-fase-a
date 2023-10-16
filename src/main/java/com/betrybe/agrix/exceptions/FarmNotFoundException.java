package com.betrybe.agrix.exceptions;

/**
 * Classe de exceção para fazenda não encontrada.
 */
public class FarmNotFoundException extends RuntimeException {

  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
