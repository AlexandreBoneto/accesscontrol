package com.boneto.accesscontrol.controller;

import com.boneto.accesscontrol.model.Occurrence;
import com.boneto.accesscontrol.service.OccurrenceService;
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
@RequestMapping("/occurrence")
public class OccurrenceController {
  @Autowired
  OccurrenceService occurrenceService;

  @PostMapping
  public Occurrence create(@RequestBody Occurrence occurrence) {
    return occurrenceService.save(occurrence);
  }

  @GetMapping
  public List<Occurrence> getList() {
    return occurrenceService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Occurrence> getById(@PathVariable("id") Long id) throws Exception {
    return ResponseEntity.ok(occurrenceService.getById(id).orElseThrow(() -> new NoSuchElementException("Not Found!")));
  }

  @PutMapping
  public Occurrence update(@RequestBody Occurrence occurrence) {
    return occurrenceService.update(occurrence);
  }

  @DeleteMapping("/{id}")
  public Map<String, Boolean> deleteById(@PathVariable("id") Long id) throws Exception {
    Map<String, Boolean> response = new HashMap<>();
    try {
      Occurrence occurrence = occurrenceService.getById(id)
          .orElseThrow(() -> new Exception("Occurrence not found for this id :: " + id));
      occurrenceService.delete(id);
      response.put("deleted", Boolean.TRUE);
    }
    catch (Exception e){
      response.put(e.getMessage(),Boolean.FALSE);
    }
    return response;
  }
}
