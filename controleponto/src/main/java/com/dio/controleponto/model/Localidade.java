package com.dio.controleponto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Localidade {
  @Id
  private long id;
  private String descricao;
  @ManyToOne
  private NivelAcesso nivelacesso;
}
