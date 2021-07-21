package com.boneto.accesscontrol.service;

import com.boneto.accesscontrol.model.Occurrence;
import com.boneto.accesscontrol.repository.OccurrenceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OccurrenceService {
  OccurrenceRepository occurrenceRepository;

  @Autowired
  public OccurrenceService(OccurrenceRepository occurrenceRepository) {
    this.occurrenceRepository = occurrenceRepository;
  }

  public Occurrence save(Occurrence occurrence) {
    return occurrenceRepository.save(occurrence);
  }

  public List<Occurrence> findAll(){
    return occurrenceRepository.findAll();
  }

  public Optional<Occurrence> getById(Long id) {
    return occurrenceRepository.findById(id);
  }

  public Occurrence update(Occurrence occurrence){
    return occurrenceRepository.save(occurrence);
  }

  public void delete(Long id) {
    occurrenceRepository.deleteById(id);
  }
}
