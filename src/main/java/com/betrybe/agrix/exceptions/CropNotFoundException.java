package com.betrybe.agrix.exceptions;

/**
 * Classe de lançamento de exceção em caso de plantação não ser encontrada.
 */
public class CropNotFoundException extends NotFoundException {
  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
