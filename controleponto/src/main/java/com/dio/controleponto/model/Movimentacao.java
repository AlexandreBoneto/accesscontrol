package com.dio.controleponto.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Movimentacao {

  @Data
  @Embeddable
  public class MovimentacaoId implements Serializable {
    private long idMovimento;
    private long idUsuario;
  }
  @EmbeddedId
  private MovimentacaoId id;
  private LocalDateTime dataEntrada;
  private LocalDateTime dataSaida;
  private BigDecimal periodo;
  @ManyToOne
  private Ocorrencia ocorrencia;
  @ManyToOne
  private Calendario calendario;
}
