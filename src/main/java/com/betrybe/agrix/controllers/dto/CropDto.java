package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;

/**
 * classe converte de DTO para entidade e vice-versa.
 *
 * @param id id da plantação
 * @param name nome da plantação
 * @param plantedArea área da plantação
 * @param farmId id da fazenda
 */
public record CropDto(Long id, String name, Double plantedArea, Long farmId) {

  /**
   * Método converte de entidade para DTO.
   *
   * @param crop plantação do tipo Crop
   * @return um objeto do tipo CropDto
   */
  public static CropDto fromEntity(Crop crop) {
    return new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getFarm().getId()
    );
  }

  /**
   * Método converte de DTO para entidade.
   *
   * @return um objeto do tipo Crop
   */
  public Crop toEntity() {
    Crop crop = new Crop();
    crop.setName(name);
    crop.setPlantedArea(plantedArea);
    return crop;
  }
}
