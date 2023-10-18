package com.betrybe.agrix.exceptions;

/**
 * classe abstrata para lançamento de exceção do tipo 404 NOT FOUND.
 */
public abstract class NotFoundException extends Exception {
  public NotFoundException(String message) {
    super(message);
  }
}
