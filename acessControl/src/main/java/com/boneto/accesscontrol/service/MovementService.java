package com.boneto.accesscontrol.service;

import com.boneto.accesscontrol.model.Movement;
import com.boneto.accesscontrol.repository.MovementRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementService {
  MovementRepository movementRepository;

  @Autowired
  public MovementService(MovementRepository movementRepository) {
    this.movementRepository = movementRepository;
  }

  public Movement save(Movement movement) {
    return movementRepository.save(movement);
  }

  public List<Movement> findAll(){
    return movementRepository.findAll();
  }

  public Optional<Movement> getById(Long id) {
    return movementRepository.findById(id);
  }

  public Movement update(Movement movement){
    return movementRepository.save(movement);
  }

  public void delete(Long id) {
    movementRepository.deleteById(id);
  }
}
