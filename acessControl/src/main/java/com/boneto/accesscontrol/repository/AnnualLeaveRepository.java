package com.boneto.accesscontrol.repository;

import com.boneto.accesscontrol.model.AnnualLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnualLeaveRepository extends JpaRepository<AnnualLeave, Long> {
}
