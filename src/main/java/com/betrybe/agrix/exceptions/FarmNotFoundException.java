package com.betrybe.agrix.exceptions;

/**
 * Classe de exceção para fazenda não encontrada.
 */
public class FarmNotFoundException extends NotFoundException {

  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
