package com.betrybe.agrix.advice;

import com.betrybe.agrix.exceptions.FarmNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * GeneralControllerAdvice.
 */
@ControllerAdvice
public class GeneralControllerAdvice {

  @ExceptionHandler(FarmNotFoundException.class)
  public ResponseEntity<String> handleNotFoundException(FarmNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }

}
