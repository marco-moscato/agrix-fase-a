package com.betrybe.agrix.services;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.repositories.CropRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * classe service de plantação.
 */
@Service
public class CropService {
  private CropRepository cropRepository;

  public CropService() {
  }

  @Autowired
  public CropService(CropRepository cropRepository) {
    this.cropRepository = cropRepository;
  }

  public Crop create(Crop crop) {
    return cropRepository.save(crop);
  }

  public List<Crop> findAll() {
    return cropRepository.findAll();
  }
}
