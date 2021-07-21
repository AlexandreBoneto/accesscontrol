package com.boneto.accesscontrol.service;

import com.boneto.accesscontrol.model.AccessLevel;
import com.boneto.accesscontrol.repository.AccessLevelRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessLevelService {
  AccessLevelRepository accessLevelRepository;

  @Autowired
  public AccessLevelService(AccessLevelRepository accessLevelRepository) {
    this.accessLevelRepository = accessLevelRepository;
  }

  public AccessLevel saveAccessLevel(AccessLevel accessLevel) {
    return accessLevelRepository.save(accessLevel);
  }

  public List<AccessLevel> findAll(){
    return accessLevelRepository.findAll();
  }

  public Optional<AccessLevel> getById(Long id) {
    return accessLevelRepository.findById(id);
  }

  public AccessLevel updateAccessLevel(AccessLevel accessLevel){
    return accessLevelRepository.save(accessLevel);
  }

  public void deleteAccessLevel(Long id) {
    accessLevelRepository.deleteById(id);
  }
}
