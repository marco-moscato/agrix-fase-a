package com.betrybe.agrix.exceptions;

public class CropNotFoundException extends NotFoundException {
  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
