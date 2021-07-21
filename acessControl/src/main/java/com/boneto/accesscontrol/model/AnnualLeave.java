package com.boneto.accesscontrol.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Data;

@Entity
@Data
public class AnnualLeave {

  @Embeddable
  @Data
  public class AnuualLeaveId implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAnuualLeaveId;
    private long idMovement;
    private long idUser;
  }

  @EmbeddedId
  private AnuualLeaveId id;
  private LocalDateTime workedDate;
  private BigDecimal hourQuantity;
  private BigDecimal hourBalance;
}
