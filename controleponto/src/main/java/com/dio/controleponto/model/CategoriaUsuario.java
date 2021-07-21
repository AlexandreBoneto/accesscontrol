package com.dio.controleponto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class CategoriaUsuario {
  @Id
  private long id;
  private String descricao;
}
