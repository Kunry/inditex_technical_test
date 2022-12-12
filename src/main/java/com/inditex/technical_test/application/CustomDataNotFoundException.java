package com.inditex.technical_test.application;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomDataNotFoundException extends ResponseStatusException {

  /**
   * @param message
   */
  public CustomDataNotFoundException(String message) {
    super(HttpStatus.NOT_FOUND, message);
  }
}