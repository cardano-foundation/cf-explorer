package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.validation.Hash32Type;
import java.util.Objects;
import javax.persistence.Column;
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
@Table(name = "cost_model", uniqueConstraints = {
    @UniqueConstraint(name = "unique_cost_model",
        columnNames = {"hash"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class CostModel extends BaseEntity {

  @Column(name = "costs", nullable = false, length = 65535)
  private String costs;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "block_id", nullable = false,
      foreignKey = @ForeignKey(name = "cost_model_block_id_fkey"))
  @EqualsAndHashCode.Exclude
  private Block block;

  @Column(name = "hash", nullable = false, length = 64)
  @Hash32Type
  private String hash;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    CostModel costModel = (CostModel) o;
    return id != null && Objects.equals(id, costModel.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
