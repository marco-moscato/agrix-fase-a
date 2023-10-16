package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.FarmDto;
import com.betrybe.agrix.controllers.dto.ResponseDto;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  /**
   * Método createFarm cria uma nova fazenda.
   *
   * @param farmDto uma fazenda no formato Dto
   * @return status 201 e a fazenda criada com id, name e size
   */
  @PostMapping()
  public ResponseEntity<Farm> createFarm(@RequestBody FarmDto farmDto) {
    Farm newFarm = farmService.insertFarm(farmDto.toFarm());
    return ResponseEntity.status(HttpStatus.CREATED).body(newFarm);
  }

  @GetMapping
  public List<Farm> getAllFarms() {
    return farmService.getAllFarms();
  }

  @GetMapping("/{farmId}")
  public ResponseEntity<ResponseDto<Farm>> getFarmById(@PathVariable Long farmId) {
    Optional<Farm> optionalFarm = farmService.getFarmById((farmId));

    if (optionalFarm.isEmpty()) {
      ResponseDto<Farm> responseDto = new ResponseDto<>("Fazenda não encontrada!", null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
    }

    ResponseDto<Farm> responseDto = new ResponseDto<>("Fazenda encontrada com sucesso!", optionalFarm.get());
    return ResponseEntity.ok(responseDto);
  }
}
