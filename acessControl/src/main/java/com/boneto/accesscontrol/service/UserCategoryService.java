package com.boneto.accesscontrol.service;

import com.boneto.accesscontrol.model.UserCategory;
import com.boneto.accesscontrol.repository.UserCategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCategoryService {
  UserCategoryRepository userCategoryRepository;

  @Autowired
  public UserCategoryService(UserCategoryRepository userCategoryRepository) {
    this.userCategoryRepository = userCategoryRepository;
  }

  public UserCategory save(UserCategory userCategory) {
    return userCategoryRepository.save(userCategory);
  }

  public List<UserCategory> findAll(){
    return userCategoryRepository.findAll();
  }

  public Optional<UserCategory> getById(Long id) {
    return userCategoryRepository.findById(id);
  }

  public UserCategory update(UserCategory userCategory){
    return userCategoryRepository.save(userCategory);
  }

  public void delete(Long id) {
    userCategoryRepository.deleteById(id);
  }
}
