package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.enumeration.TokenType;
import com.sotatek.cardano.common.validation.Hash28Type;
import com.sotatek.cardano.common.validation.Hash32Type;
import com.sotatek.cardano.common.validation.Lovelace;
import com.sotatek.cardano.common.validation.TxIndex;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "tx_out", uniqueConstraints = {
    @UniqueConstraint(name = "unique_txout",
        columnNames = {"tx_id", "index"}
    )
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class TxOut extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "tx_id", nullable = false,
      foreignKey = @ForeignKey(name = "tx_out_tx_id_fkey"))
  @EqualsAndHashCode.Exclude
  private Tx tx;

  @Column(name = "index", nullable = false)
  @TxIndex
  private Short index;

  @Column(name = "address", nullable = false, length = 65535)
  private String address;

  @Column(name = "address_raw", nullable = false)
  private byte[] addressRaw;

  @Column(name = "address_has_script", nullable = false)
  private Boolean addressHasScript;

  @Column(name = "payment_cred", length = 56)
  @Hash28Type
  private String paymentCred;

  @ManyToOne(fetch = FetchType.LAZY)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "stake_address_id",
      foreignKey = @ForeignKey(name = "tx_out_stake_address_id_fkey"))
  @EqualsAndHashCode.Exclude
  private StakeAddress stakeAddress;

  @Column(name = "value", nullable = false, precision = 20)
  @Lovelace
  @Digits(integer = 20, fraction = 0)
  private BigDecimal value;

  @Column(name = "token_type", nullable = false)
  private TokenType tokenType;

  @Column(name = "has_used")
  private Boolean hasUsed;

  @Column(name = "data_hash", length = 64)
  @Hash32Type
  private String dataHash;

  @ManyToOne(fetch = FetchType.LAZY)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "inline_datum_id",
      foreignKey = @ForeignKey(name = "tx_out_inline_datum_id_fkey"))
  @EqualsAndHashCode.Exclude
  private Datum inlineDatum;

  @ManyToOne(fetch = FetchType.LAZY)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "reference_script_id",
      foreignKey = @ForeignKey(name = "tx_out_reference_script_id_fkey"))
  @EqualsAndHashCode.Exclude
  private Script referenceScript;

  @OneToMany(mappedBy = "txOut")
  private List<MaTxOut> maTxOuts;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    TxOut txOut = (TxOut) o;
    return id != null && Objects.equals(id, txOut.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
