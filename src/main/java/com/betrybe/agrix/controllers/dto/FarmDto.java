package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Farm;

/**
 * Classe responsável por intermediar a comunicação entre requisição e aplicação.
 *
 * @param id id da fazenda
 * @param name nome da fazenda
 * @param size tamanho da fazenda
 */
public record FarmDto(Long id, String name, Double size) {
  public Farm toFarm() {
    return new Farm(id, name, size);
  }
}
