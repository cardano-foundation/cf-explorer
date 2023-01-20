package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.validation.Word64Type;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
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
@Table(name = "ma_tx_out", uniqueConstraints = {
    @UniqueConstraint(name = "unique_ma_tx_out",
        columnNames = {"ident", "tx_out_id"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class MaTxOut extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "ident", nullable = false,
      foreignKey = @ForeignKey(name = "ma_tx_out_ident_fkey"))
  @EqualsAndHashCode.Exclude
  private MultiAsset ident;

  @Column(name = "quantity", nullable = false, precision = 20)
  @Word64Type
  @Digits(integer = 20, fraction = 0)
  private BigDecimal quantity;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "tx_out_id", nullable = false,
      foreignKey = @ForeignKey(name = "ma_tx_out_tx_out_id_fkey"))
  @EqualsAndHashCode.Exclude
  private TxOut txOut;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    MaTxOut maTxOut = (MaTxOut) o;
    return id != null && Objects.equals(id, maTxOut.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
