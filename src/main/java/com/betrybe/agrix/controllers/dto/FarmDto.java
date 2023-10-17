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

  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(
        farm.getId(),
        farm.getName(),
        farm.getSize()
    );
  }
  public Farm toEntity() {
    Farm farm = new Farm();
    farm.setName(name);
    farm.setSize(size);
    return farm;
  }
}
