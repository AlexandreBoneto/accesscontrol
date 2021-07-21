package com.boneto.accesscontrol.controller;

import com.boneto.accesscontrol.model.User;
import com.boneto.accesscontrol.service.UserService;
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
@RequestMapping("/user")
public class UserController {
  @Autowired
  UserService userService;

  @PostMapping
  public User create(@RequestBody User user) {
    return userService.save(user);
  }

  @GetMapping
  public List<User> getList() {
    return userService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getById(@PathVariable("id") Long id) throws Exception {
    return ResponseEntity.ok(userService.getById(id).orElseThrow(() -> new NoSuchElementException("Not Found!")));
  }

  @PutMapping
  public User update(@RequestBody User user) {
    return userService.update(user);
  }

  @DeleteMapping("/{id}")
  public Map<String, Boolean> deleteById(@PathVariable("id") Long id) throws Exception {
    Map<String, Boolean> response = new HashMap<>();
    try {
      User user = userService.getById(id)
          .orElseThrow(() -> new Exception("User not found for this id :: " + id));
      userService.delete(id);
      response.put("deleted", Boolean.TRUE);
    }
    catch (Exception e){
      response.put(e.getMessage(),Boolean.FALSE);
    }
    return response;
  }
}
