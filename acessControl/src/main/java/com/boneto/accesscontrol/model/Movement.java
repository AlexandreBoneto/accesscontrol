package com.boneto.accesscontrol.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Movement {
  @Embeddable
  @Data
  public class MovementId implements Serializable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private long idUser;
  }
  @EmbeddedId
  private MovementId movementId;
  private LocalDateTime entryDate;
  private LocalDateTime exitDate;
  private BigDecimal timeCourse;
  @ManyToOne
  private Occurrence occurrence;
  @ManyToOne
  private Calendar calendar;
}
