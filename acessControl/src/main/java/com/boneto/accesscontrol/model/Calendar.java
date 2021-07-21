package com.boneto.accesscontrol.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Calendar {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne
  private DataType dataType;
  private String description;
  private LocalDateTime specialDate;

}
