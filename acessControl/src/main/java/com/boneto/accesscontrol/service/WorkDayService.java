package com.boneto.accesscontrol.service;

import com.boneto.accesscontrol.model.WorkDay;
import com.boneto.accesscontrol.repository.WorkDayRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkDayService {
  WorkDayRepository workDayRepository;

  @Autowired
  public WorkDayService(WorkDayRepository workDayRepository) {
    this.workDayRepository = workDayRepository;
  }

  public WorkDay saveWorkDay(WorkDay workDay) {
    return workDayRepository.save(workDay);
  }

  public List<WorkDay> findAll(){
    return workDayRepository.findAll();
  }

  public Optional<WorkDay> getById(Long idWorkDay) {
    return workDayRepository.findById(idWorkDay);
  }

  public WorkDay updateWorkDay(WorkDay workDay){
    return workDayRepository.save(workDay);
  }

  public void deleteWorkDay(Long idWorkDay) {
    workDayRepository.deleteById(idWorkDay);
  }
}
