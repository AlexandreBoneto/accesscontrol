package com.boneto.accesscontrol.controller;

import com.boneto.accesscontrol.model.UserCategory;
import com.boneto.accesscontrol.service.UserCategoryService;
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
@RequestMapping("/usercategory")
public class UserCategoryController {
  @Autowired
  UserCategoryService userCategoryService;

  @PostMapping
  public UserCategory create(@RequestBody UserCategory userCategory) {
    return userCategoryService.save(userCategory);
  }

  @GetMapping
  public List<UserCategory> getList() {
    return userCategoryService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserCategory> getById(@PathVariable("id") Long id) throws Exception {
    return ResponseEntity.ok(userCategoryService.getById(id).orElseThrow(() -> new NoSuchElementException("Not Found!")));
  }

  @PutMapping
  public UserCategory update(@RequestBody UserCategory userCategory) {
    return userCategoryService.update(userCategory);
  }

  @DeleteMapping("/{id}")
  public Map<String, Boolean> deleteById(@PathVariable("id") Long id) throws Exception {
    Map<String, Boolean> response = new HashMap<>();
    try {
      UserCategory userCategory = userCategoryService.getById(id)
          .orElseThrow(() -> new Exception("UserCategory not found for this id :: " + id));
      userCategoryService.delete(id);
      response.put("deleted", Boolean.TRUE);
    }
    catch (Exception e){
      response.put(e.getMessage(),Boolean.FALSE);
    }
    return response;
  }
}
