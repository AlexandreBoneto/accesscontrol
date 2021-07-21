package com.dio.controleponto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Generated;

@Data
@Builder
@Entity
public class JornadaTrabalho {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String descricao;
}
