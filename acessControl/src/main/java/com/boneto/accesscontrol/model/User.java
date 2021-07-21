package com.boneto.accesscontrol.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne
  private UserCategory userCategory;
  private String name;
  @ManyToOne
  private Company company;
  @ManyToOne
  private AccessLevel accessLevel;
  @ManyToOne
  private WorkDay workDay;
  private BigDecimal tolerance;
  private LocalDateTime workDayStart;
  private LocalDateTime workDayEnd;

}
