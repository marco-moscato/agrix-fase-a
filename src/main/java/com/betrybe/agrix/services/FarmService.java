package com.betrybe.agrix.services;

import com.betrybe.agrix.exceptions.FarmNotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * classe service da fazenda.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;
  private final CropService cropService;


  @Autowired
  public FarmService(FarmRepository farmRepository, CropService cropService) {
    this.farmRepository = farmRepository;
    this.cropService = cropService;
  }

  public Farm insertFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  public List<Farm> getAllFarms() {
    return farmRepository.findAll();
  }

  public Farm findFarmById(long id) throws FarmNotFoundException {
    return farmRepository.findById(id)
        .orElseThrow(FarmNotFoundException::new);
  }

  /**
   * Método cria uma plantação.
   *
   * @param crop objeto que representa uma plantação do tipo Crop
   * @param farmId id da fazenda a qual a plantação será associada
   * @return a plantação criada e associada a uma fazenda
   * @throws FarmNotFoundException exceção em caso do id da fazenda não ser encontrado
   */
  public Crop createCrop(Crop crop, long farmId) throws FarmNotFoundException {
    Farm farm = findFarmById(farmId);
    crop.setFarm(farm);
    return cropService.create(crop);
  }
}
