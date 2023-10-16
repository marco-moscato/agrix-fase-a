package com.betrybe.agrix.controllers;

import com.betrybe.agrix.services.FarmService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe responsável pelo service da fazenda.
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {
  private final FarmService farmService;

  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }
}
