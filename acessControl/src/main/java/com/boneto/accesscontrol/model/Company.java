package com.boneto.accesscontrol.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Company {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;
  private String description;
  private String cnpj;
  private String address;
  private String district;
  private String city;
  private String state;
  private String phone;
}
