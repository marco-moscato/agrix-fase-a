package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.controllers.dto.FarmDto;
import com.betrybe.agrix.exceptions.FarmNotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

  /**
   * Método createFarm cria uma nova fazenda.
   *
   * @param newFarm uma fazenda no formato Dto
   * @return status 201 e a fazenda criada com id, name e size
   */
  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public FarmDto createFarm(@RequestBody FarmDto newFarm) {
    Farm savedFarm = farmService.insertFarm(newFarm.toEntity());
    return FarmDto.fromEntity(savedFarm);
  }

  /**
   * Método busca por todas as fazendas.
   *
   * @return uma lista de fazendas com status 200
   */
  @GetMapping
  public List<FarmDto> getAllFarms() {
    List<Farm> farms = farmService.getAllFarms();
    return farms.stream()
        .map(FarmDto::fromEntity)
        .toList();
  }

  /**
   * Método busca uma fazenda pelo id.
   *
   * @param id id da fazenda
   * @return dados da fazenda ou erro 404 not found
   */
  @GetMapping("/{id}")
  public FarmDto findFarmById(@PathVariable("id") long id)
      throws FarmNotFoundException {
    return FarmDto.fromEntity(farmService.findFarmById(id));
  }

  /**
   * Método cria uma plantação.
   *
   * @param crop dado de uma plantação do tipo CropDto
   * @param farmId id da fazenda da qual a fazenda estará associada
   * @return status 201 e dados da plantação do tipo CropDto
   * @throws FarmNotFoundException exceção caso id da fazenda não seja encontrado
   */
  @PostMapping("/{farmId}/crops")
  public ResponseEntity<CropDto> createCrop(
      @RequestBody CropDto crop,
      @PathVariable("farmId") long farmId
  ) throws FarmNotFoundException {
    Crop savedCrop = farmService.createCrop(crop.toEntity(), farmId);
    CropDto cropDto = CropDto.fromEntity(savedCrop);
    return ResponseEntity.status(HttpStatus.CREATED).body(cropDto);
  }
}
