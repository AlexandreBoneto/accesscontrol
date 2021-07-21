package com.boneto.accesscontrol.repository;

import com.boneto.accesscontrol.model.DataType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataTypeRepository extends JpaRepository<DataType, Long> {
}
