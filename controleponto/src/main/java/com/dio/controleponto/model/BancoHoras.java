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
public class BancoHoras {
  @Data
  @Embeddable
  public class BancoHorasId implements Serializable {
    private long idBancoHoras;
    private long idMovimento;
    private long idUsuario;
  }

  @EmbeddedId
  private BancoHorasId bancoHorasId;
  @ManyToOne
  private CategoriaUsuario categoriaUsuario;
  private LocalDateTime dataTrabalhada;
  private BigDecimal qtdHorasTrabalhadas;
  private BigDecimal saldoHorasTrabalhadas;
}
