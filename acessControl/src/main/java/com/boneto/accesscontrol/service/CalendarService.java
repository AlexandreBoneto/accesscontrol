package com.boneto.accesscontrol.service;

import com.boneto.accesscontrol.model.Calendar;
import com.boneto.accesscontrol.repository.CalendarRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarService {
  CalendarRepository calendarRepository;

  @Autowired
  public CalendarService(CalendarRepository calendarRepository) {
    this.calendarRepository = calendarRepository;
  }

  public Calendar save(Calendar calendar) {
    return calendarRepository.save(calendar);
  }

  public List<Calendar> findAll(){
    return calendarRepository.findAll();
  }

  public Optional<Calendar> getById(Long id) {
    return calendarRepository.findById(id);
  }

  public Calendar update(Calendar calendar){
    return calendarRepository.save(calendar);
  }

  public void delete(Long id) {
    calendarRepository.deleteById(id);
  }
}
