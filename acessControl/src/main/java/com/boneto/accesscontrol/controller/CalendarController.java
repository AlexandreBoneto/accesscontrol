package com.boneto.accesscontrol.controller;

import com.boneto.accesscontrol.model.Calendar;
import com.boneto.accesscontrol.service.CalendarService;
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
@RequestMapping("/calendar")
public class CalendarController {
  @Autowired
  CalendarService calendarService;

  @PostMapping
  public Calendar create(@RequestBody Calendar calendar) {
    return calendarService.save(calendar);
  }

  @GetMapping
  public List<Calendar> getList() {
    return calendarService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Calendar> getById(@PathVariable("id") Long id) throws Exception {
    return ResponseEntity.ok(calendarService.getById(id).orElseThrow(() -> new NoSuchElementException("Not Found!")));
  }

  @PutMapping
  public Calendar update(@RequestBody Calendar calendar) {
    return calendarService.update(calendar);
  }

  @DeleteMapping("/{id}")
  public Map<String, Boolean> deleteById(@PathVariable("id") Long id) throws Exception {
    Map<String, Boolean> response = new HashMap<>();
    try {
      Calendar calendar = calendarService.getById(id)
          .orElseThrow(() -> new Exception("Calendar not found for this id :: " + id));
      calendarService.delete(id);
      response.put("deleted", Boolean.TRUE);
    }
    catch (Exception e){
      response.put(e.getMessage(),Boolean.FALSE);
    }
    return response;
  }
}
