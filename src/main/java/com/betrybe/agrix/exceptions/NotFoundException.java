package com.betrybe.agrix.exceptions;

public abstract class NotFoundException extends Exception {
  public NotFoundException(String message) {
    super(message);
  }
}
