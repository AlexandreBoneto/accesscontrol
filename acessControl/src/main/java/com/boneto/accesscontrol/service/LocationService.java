package com.boneto.accesscontrol.service;

import com.boneto.accesscontrol.model.Location;
import com.boneto.accesscontrol.repository.LocationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
  LocationRepository locationRepository;

  @Autowired
  public LocationService(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  public Location save(Location location) {
    return locationRepository.save(location);
  }

  public List<Location> findAll(){
    return locationRepository.findAll();
  }

  public Optional<Location> getById(Long id) {
    return locationRepository.findById(id);
  }

  public Location update(Location location){
    return locationRepository.save(location);
  }

  public void delete(Long id) {
    locationRepository.deleteById(id);
  }
}
