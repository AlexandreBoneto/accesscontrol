package com.boneto.accesscontrol.service;

import com.boneto.accesscontrol.model.User;
import com.boneto.accesscontrol.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public List<User> findAll(){
    return userRepository.findAll();
  }

  public Optional<User> getById(Long id) {
    return userRepository.findById(id);
  }

  public User update(User user){
    return userRepository.save(user);
  }

  public void delete(Long id) {
    userRepository.deleteById(id);
  }
}
