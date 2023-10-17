package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.FarmDto;
import com.betrybe.agrix.exceptions.FarmNotFoundException;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import org.springframework.http.HttpStatus;
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
   * @param farmDto uma fazenda no formato Dto
   * @return status 201 e a fazenda criada com id, name e size
   */
  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public Farm createFarm(@RequestBody FarmDto farmDto) {
    return farmService.insertFarm(farmDto.toEntity());
  }

  @GetMapping
  public List<Farm> getAllFarms() {
    return farmService.getAllFarms();
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

}
