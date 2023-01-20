package com.sotatek.cardano.common.entity;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

@Entity
@Table(name = "pool_stake", uniqueConstraints = {
    @UniqueConstraint(name = "uni_pool_id",
        columnNames = {"pool_id"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class PoolStake extends BaseEntity {

  @OneToOne
  @JoinColumn(name = "pool_id")
  private PoolHash pool;

  @Column(name = "amount")
  private BigDecimal amount;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    PoolStake poolStake = (PoolStake) o;
    return id != null && Objects.equals(id, poolStake.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
