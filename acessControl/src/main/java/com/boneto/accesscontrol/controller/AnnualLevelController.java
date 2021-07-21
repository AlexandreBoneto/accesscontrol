package com.boneto.accesscontrol.controller;

import com.boneto.accesscontrol.model.AccessLevel;
import com.boneto.accesscontrol.model.AnnualLeave;
import com.boneto.accesscontrol.service.AccessLevelService;
import com.boneto.accesscontrol.service.AnnualLeaveService;
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
@RequestMapping("/annuallevel")
public class AnnualLevelController {
  @Autowired
  AnnualLeaveService annualLeaveService;

  @PostMapping
  public AnnualLeave create(@RequestBody AnnualLeave annualLeave) {
    return annualLeaveService.save(annualLeave);
  }

  @GetMapping
  public List<AnnualLeave> getList() {
    return annualLeaveService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<AnnualLeave> getById(@PathVariable("id") Long id) throws Exception {
    return ResponseEntity.ok(annualLeaveService.getById(id).orElseThrow(() -> new NoSuchElementException("Not Found!")));
  }

  @PutMapping
  public AnnualLeave update(@RequestBody AnnualLeave annualLeave) {
    return annualLeaveService.update(annualLeave);
  }

  @DeleteMapping("/{id}")
  public Map<String, Boolean> deleteById(@PathVariable("id") Long id) throws Exception {
    Map<String, Boolean> response = new HashMap<>();
    try {
      AnnualLeave annualLeave = annualLeaveService.getById(id)
          .orElseThrow(() -> new Exception("Annual Leave not found for this id :: " + id));
      annualLeaveService.delete(id);
      response.put("deleted", Boolean.TRUE);
    }
    catch (Exception e){
      response.put(e.getMessage(),Boolean.FALSE);
    }
    return response;
  }
}
