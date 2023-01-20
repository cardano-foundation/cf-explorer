package com.sotatek.cardano.common.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "pool_owner", uniqueConstraints = {
    @UniqueConstraint(name = "unique_pool_owner",
        columnNames = {"addr_id", "pool_update_id"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class PoolOwner extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "addr_id", nullable = false,
      foreignKey = @ForeignKey(name = "pool_owner_addr_id_fkey"))
  @EqualsAndHashCode.Exclude
  private StakeAddress stakeAddress;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "pool_update_id", nullable = false,
      foreignKey = @ForeignKey(name = "pool_owner_pool_update_id_fkey"))
  @EqualsAndHashCode.Exclude
  private PoolUpdate poolUpdate;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    PoolOwner poolOwner = (PoolOwner) o;
    return id != null && Objects.equals(id, poolOwner.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
