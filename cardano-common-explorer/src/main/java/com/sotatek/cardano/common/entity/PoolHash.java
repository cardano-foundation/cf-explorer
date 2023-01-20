package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.validation.Hash28Type;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@Table(name = "pool_hash", uniqueConstraints = {
    @UniqueConstraint(name = "unique_pool_hash",
        columnNames = {"hash_raw"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class PoolHash extends BaseEntity {

  @Column(name = "hash_raw", nullable = false, length = 56)
  @Hash28Type
  private String hashRaw;

  @Column(name = "view", nullable = false)
  private String view;

  @Digits(integer = 20, fraction = 0)
  @Column(name = "pool_size", nullable = false, precision = 20)
  private BigDecimal poolSize;

  @OneToMany(mappedBy = "poolHash")
  private List<Delegation> delegations;

  @Column(name = "epoch_no")
  private Integer epochNo;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    PoolHash poolHash = (PoolHash) o;
    return id != null && Objects.equals(id, poolHash.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
