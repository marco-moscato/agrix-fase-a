package com.betrybe.agrix.exceptions;

/**
 * Classe de exceção para fazenda não encontrada.
 */
public class FarmNotFoundException extends Exception {

  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
