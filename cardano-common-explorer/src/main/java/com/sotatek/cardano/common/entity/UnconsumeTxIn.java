package com.sotatek.cardano.common.entity;


import com.sotatek.cardano.common.validation.TxIndex;
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
@Table(name = "unconsume_tx_in", uniqueConstraints = {
    @UniqueConstraint(name = "unique_col_txin",
        columnNames = {"tx_in_id","tx_out_id", "tx_out_index"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class UnconsumeTxIn extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "tx_in_id", nullable = false,
      foreignKey = @ForeignKey(name = "unsconume_tx_in_tx_in_id_fkey"))
  @EqualsAndHashCode.Exclude
  private Tx txIn;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "tx_out_id", nullable = false,
      foreignKey = @ForeignKey(name = "unsconume_tx_in_tx_out_id_fkey"))
  @EqualsAndHashCode.Exclude
  private Tx txOut;

  @Column(name = "tx_out_index", nullable = false)
  @TxIndex
  private Short txOutIndex;


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    UnconsumeTxIn that = (UnconsumeTxIn) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
