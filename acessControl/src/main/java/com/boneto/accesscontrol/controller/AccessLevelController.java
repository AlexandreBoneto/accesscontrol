package com.boneto.accesscontrol.controller;

import com.boneto.accesscontrol.model.AccessLevel;
import com.boneto.accesscontrol.service.AccessLevelService;
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
@RequestMapping("/accesslevel")
public class AccessLevelController {
  @Autowired
  AccessLevelService accessLevelService;

  @PostMapping
  public AccessLevel create(@RequestBody AccessLevel accessLevel) {
    return accessLevelService.saveAccessLevel(accessLevel);
  }

  @GetMapping
  public List<AccessLevel> getList() {
    return accessLevelService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<AccessLevel> getById(@PathVariable("id") Long id) throws Exception {
    return ResponseEntity.ok(accessLevelService.getById(id).orElseThrow(() -> new NoSuchElementException("Not Found!")));
  }

  @PutMapping
  public AccessLevel update(@RequestBody AccessLevel accessLevel) {
    return accessLevelService.updateAccessLevel(accessLevel);
  }

  @DeleteMapping("/{id}")
  public Map<String, Boolean> deleteById(@PathVariable("id") Long id) throws Exception {
    Map<String, Boolean> response = new HashMap<>();
    try {
      AccessLevel accessLevel = accessLevelService.getById(id)
          .orElseThrow(() -> new Exception("Access Level not found for this id :: " + id));
      accessLevelService.deleteAccessLevel(id);
      response.put("deleted", Boolean.TRUE);
    }
    catch (Exception e){
      response.put(e.getMessage(),Boolean.FALSE);
    }
    return response;
  }
}
