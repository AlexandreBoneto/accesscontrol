package com.boneto.accesscontrol.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Location {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne
  private AccessLevel accessLevel;
  private String description;
}
