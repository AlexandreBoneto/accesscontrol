package com.boneto.accesscontrol.repository;

import com.boneto.accesscontrol.model.Occurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Long> {
}
