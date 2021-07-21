package com.dio.controleponto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class NivelAcesso {
  @Id
  private long id;
  private String descricao;
}
