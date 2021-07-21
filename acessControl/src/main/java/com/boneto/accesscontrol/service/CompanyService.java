package com.boneto.accesscontrol.service;

import com.boneto.accesscontrol.model.Company;
import com.boneto.accesscontrol.repository.CompanyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
  CompanyRepository companyRepository;

  @Autowired
  public CompanyService(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  public Company save(Company company) {
    return companyRepository.save(company);
  }

  public List<Company> findAll(){
    return companyRepository.findAll();
  }

  public Optional<Company> getById(Long id) {
    return companyRepository.findById(id);
  }

  public Company update(Company company){
    return companyRepository.save(company);
  }

  public void delete(Long id) {
    companyRepository.deleteById(id);
  }
}
