package com.boneto.accesscontrol.controller;

import com.boneto.accesscontrol.model.Location;
import com.boneto.accesscontrol.service.LocationService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {
  @Autowired
  LocationService locationService;

  @PostMapping
  public Location create(@RequestBody Location location) {
    return locationService.save(location);
  }

  @GetMapping
  public List<Location> getList() {
    return locationService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Location> getById(@PathVariable("id") Long id) throws Exception {
    return ResponseEntity.ok(locationService.getById(id).orElseThrow(() -> new NoSuchElementException("Not Found!")));
  }

  @PutMapping
  public Location update(@RequestBody Location location) {
    return locationService.update(location);
  }

  @DeleteMapping("/{id}")
  public Map<String, Boolean> deleteById(@PathVariable("id") Long id) throws Exception {
    Map<String, Boolean> response = new HashMap<>();
    try {
      Location location = locationService.getById(id)
          .orElseThrow(() -> new Exception("Location not found for this id :: " + id));
      locationService.delete(id);
      response.put("deleted", Boolean.TRUE);
    }
    catch (Exception e){
      response.put(e.getMessage(),Boolean.FALSE);
    }
    return response;
  }
}
