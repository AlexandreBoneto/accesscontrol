package com.boneto.accesscontrol.controller;

import com.boneto.accesscontrol.model.Company;
import com.boneto.accesscontrol.service.CompanyService;
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
@RequestMapping("/company")
public class CompanyController {
  @Autowired
  CompanyService companyService;

  @PostMapping
  public Company create(@RequestBody Company company) {
    return companyService.save(company);
  }

  @GetMapping
  public List<Company> getList() {
    return companyService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Company> getById(@PathVariable("id") Long id) throws Exception {
    return ResponseEntity.ok(companyService.getById(id).orElseThrow(() -> new NoSuchElementException("Not Found!")));
  }

  @PutMapping
  public Company update(@RequestBody Company company) {
    return companyService.update(company);
  }

  @DeleteMapping("/{id}")
  public Map<String, Boolean> deleteById(@PathVariable("id") Long id) throws Exception {
    Map<String, Boolean> response = new HashMap<>();
    try {
      Company company = companyService.getById(id)
          .orElseThrow(() -> new Exception("Company not found for this id :: " + id));
      companyService.delete(id);
      response.put("deleted", Boolean.TRUE);
    }
    catch (Exception e){
      response.put(e.getMessage(),Boolean.FALSE);
    }
    return response;
  }
}
