package com.boneto.accesscontrol.repository;

import com.boneto.accesscontrol.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
