package com.boneto.accesscontrol.service;

import com.boneto.accesscontrol.model.DataType;
import com.boneto.accesscontrol.repository.DataTypeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataTypeService {
  DataTypeRepository dataTypeRepository;

  @Autowired
  public DataTypeService(DataTypeRepository dataTypeRepository) {
    this.dataTypeRepository = dataTypeRepository;
  }

  public DataType save(DataType dataType) {
    return dataTypeRepository.save(dataType);
  }

  public List<DataType> findAll(){
    return dataTypeRepository.findAll();
  }

  public Optional<DataType> getById(Long id) {
    return dataTypeRepository.findById(id);
  }

  public DataType update(DataType dataType){
    return dataTypeRepository.save(dataType);
  }

  public void delete(Long id) {
    dataTypeRepository.deleteById(id);
  }
}
