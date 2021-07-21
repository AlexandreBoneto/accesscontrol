package com.boneto.accesscontrol.controller;

import com.boneto.accesscontrol.model.WorkDay;
import com.boneto.accesscontrol.service.WorkDayService;
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
@RequestMapping("/workday")
public class WorkDayController {
  @Autowired
  WorkDayService workDayService;

  @PostMapping
  public WorkDay create(@RequestBody WorkDay workDay) {
    return workDayService.saveWorkDay(workDay);
  }

  @GetMapping
  public List<WorkDay> getList() {
    return workDayService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<WorkDay> getById(@PathVariable("id") Long idWorkDay) throws Exception {
    return ResponseEntity.ok(workDayService.getById(idWorkDay).orElseThrow(() -> new NoSuchElementException("Not Found!")));
  }

  @PutMapping
  public WorkDay update(@RequestBody WorkDay workDay) {
    return workDayService.updateWorkDay(workDay);
  }

  @DeleteMapping("/{id}")
  public Map<String, Boolean> deleteById(@PathVariable("id") Long idWorkDay) throws Exception {
    Map<String, Boolean> response = new HashMap<>();
    try {
      WorkDay workDay = workDayService.getById(idWorkDay)
          .orElseThrow(() -> new Exception("Workday not found for this id :: " + idWorkDay));
      workDayService.deleteWorkDay(idWorkDay);
      response.put("deleted", Boolean.TRUE);
    }
    catch (Exception e){
      response.put(e.getMessage(),Boolean.FALSE);
    }
    return response;
  }
}
