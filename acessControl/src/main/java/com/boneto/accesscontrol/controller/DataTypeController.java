package com.boneto.accesscontrol.controller;

import com.boneto.accesscontrol.model.DataType;
import com.boneto.accesscontrol.service.DataTypeService;
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
@RequestMapping("/datatype")
public class DataTypeController {
  @Autowired
  DataTypeService dataTypeService;

  @PostMapping
  public DataType create(@RequestBody DataType dataType) {
    return dataTypeService.save(dataType);
  }

  @GetMapping
  public List<DataType> getList() {
    return dataTypeService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<DataType> getById(@PathVariable("id") Long id) throws Exception {
    return ResponseEntity.ok(dataTypeService.getById(id).orElseThrow(() -> new NoSuchElementException("Not Found!")));
  }

  @PutMapping
  public DataType update(@RequestBody DataType dataType) {
    return dataTypeService.update(dataType);
  }

  @DeleteMapping("/{id}")
  public Map<String, Boolean> deleteById(@PathVariable("id") Long id) throws Exception {
    Map<String, Boolean> response = new HashMap<>();
    try {
      DataType dataType = dataTypeService.getById(id)
          .orElseThrow(() -> new Exception("DataType not found for this id :: " + id));
      dataTypeService.delete(id);
      response.put("deleted", Boolean.TRUE);
    }
    catch (Exception e){
      response.put(e.getMessage(),Boolean.FALSE);
    }
    return response;
  }
}
