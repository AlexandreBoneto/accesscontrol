package com.dio.controleponto.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Calendario {
  @Id
  private long id;
  @ManyToOne
  private TipoData tipoData;
  private String descricao;
  private LocalDateTime dataEspecial;
}
