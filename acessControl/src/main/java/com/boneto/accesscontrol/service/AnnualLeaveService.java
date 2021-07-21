package com.boneto.accesscontrol.service;

import com.boneto.accesscontrol.model.AccessLevel;
import com.boneto.accesscontrol.model.AnnualLeave;
import com.boneto.accesscontrol.repository.AccessLevelRepository;
import com.boneto.accesscontrol.repository.AnnualLeaveRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnualLeaveService {
  AnnualLeaveRepository annualLeaveRepository;

  @Autowired
  public AnnualLeaveService(AnnualLeaveRepository annualLeaveRepository) {
    this.annualLeaveRepository = annualLeaveRepository;
  }

  public AnnualLeave save(AnnualLeave annualLeave) {
    return annualLeaveRepository.save(annualLeave);
  }

  public List<AnnualLeave> findAll(){
    return annualLeaveRepository.findAll();
  }

  public Optional<AnnualLeave> getById(Long id) {
    return annualLeaveRepository.findById(id);
  }

  public AnnualLeave update(AnnualLeave annualLeave){
    return annualLeaveRepository.save(annualLeave);
  }

  public void delete(Long id) {
    annualLeaveRepository.deleteById(id);
  }
}
