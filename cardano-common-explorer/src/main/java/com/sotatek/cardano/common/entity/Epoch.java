package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.validation.Lovelace;
import com.sotatek.cardano.common.validation.Word128Type;
import com.sotatek.cardano.common.validation.Word31Type;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

@Entity
@Table(name = "epoch", uniqueConstraints = {
    @UniqueConstraint(name = "unique_epoch",
        columnNames = {"no"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Epoch extends BaseEntity {

  @Column(name = "out_sum", nullable = false, precision = 39)
  @Word128Type
  @Digits(integer = 39, fraction = 0)
  private BigDecimal outSum;

  @Column(name = "fees", nullable = false, precision = 20)
  @Lovelace
  @Digits(integer = 20, fraction = 0)
  private BigDecimal fees;

  @Column(name = "tx_count", nullable = false)
  @Word31Type
  private Integer txCount;

  @Column(name = "blk_count", nullable = false)
  @Word31Type
  private Integer blkCount;

  @Column(name = "no", nullable = false)
  @Word31Type
  private Integer no;

  @Column(name = "start_time")
  private Timestamp startTime;

  @Column(name = "end_time")
  private Timestamp endTime;

  @Column(name="max_slot", nullable = false)
  private Integer maxSlot;

/*  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "epoch_no" ,insertable =false, updatable = false)
  private Set<Block> blocks;*/

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Epoch epoch = (Epoch) o;
    return id != null && Objects.equals(id, epoch.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
