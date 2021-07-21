package com.boneto.accesscontrol.controller;

import com.boneto.accesscontrol.model.Movement;
import com.boneto.accesscontrol.service.MovementService;
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
@RequestMapping("/movement")
public class MovementController {
  @Autowired
  MovementService movementService;

  @PostMapping
  public Movement create(@RequestBody Movement movement) {
    return movementService.save(movement);
  }

  @GetMapping
  public List<Movement> getList() {
    return movementService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Movement> getById(@PathVariable("id") Long id) throws Exception {
    return ResponseEntity.ok(movementService.getById(id).orElseThrow(() -> new NoSuchElementException("Not Found!")));
  }

  @PutMapping
  public Movement update(@RequestBody Movement movement) {
    return movementService.update(movement);
  }

  @DeleteMapping("/{id}")
  public Map<String, Boolean> deleteById(@PathVariable("id") Long id) throws Exception {
    Map<String, Boolean> response = new HashMap<>();
    try {
      Movement movement = movementService.getById(id)
          .orElseThrow(() -> new Exception("Movement not found for this id :: " + id));
      movementService.delete(id);
      response.put("deleted", Boolean.TRUE);
    }
    catch (Exception e){
      response.put(e.getMessage(),Boolean.FALSE);
    }
    return response;
  }
}
