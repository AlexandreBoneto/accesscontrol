package com.dio.controleponto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Empresa {
  @Id
  private long id;
  private String descricao;
  private String cnpj;
  private String endereco;
  private String bairro;
  private String cidade;
  private String estado;
  private String telefone;
}
