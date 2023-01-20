package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.validation.Hash32Type;
import com.sotatek.cardano.common.validation.Lovelace;
import com.sotatek.cardano.common.validation.Word31Type;
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
@Table(name = "epoch_param", uniqueConstraints = {
    @UniqueConstraint(name = "unique_epoch_param",
        columnNames = {"epoch_no", "block_id"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class EpochParam extends BaseEntity {

  @Column(name = "epoch_no", nullable = false)
  @Word31Type
  private Integer epochNo;

  @Column(name = "min_fee_a", nullable = false)
  @Word31Type
  private Integer minFeeA;

  @Column(name = "min_fee_b", nullable = false)
  @Word31Type
  private Integer minFeeB;

  @Column(name = "max_block_size", nullable = false)
  @Word31Type
  private Integer maxBlockSize;

  @Column(name = "max_tx_size", nullable = false)
  @Word31Type
  private Integer maxTxSize;

  @Column(name = "max_bh_size", nullable = false)
  @Word31Type
  private Integer maxBhSize;

  @Column(name = "key_deposit", nullable = false, precision = 20)
  @Lovelace
  @Digits(integer = 20, fraction = 0)
  private BigDecimal keyDeposit;

  @Column(name = "pool_deposit", nullable = false, precision = 20)
  @Lovelace
  @Digits(integer = 20, fraction = 0)
  private BigDecimal poolDeposit;

  @Column(name = "max_epoch", nullable = false)
  @Word31Type
  private Integer maxEpoch;

  @Column(name = "optimal_pool_count", nullable = false)
  @Word31Type
  private Integer optimalPoolCount;

  @Column(name = "influence", nullable = false)
  private Double influence;

  @Column(name = "monetary_expand_rate", nullable = false)
  private Double monetaryExpandRate;

  @Column(name = "treasury_growth_rate", nullable = false)
  private Double treasuryGrowthRate;

  @Column(name = "decentralisation", nullable = false)
  private Double decentralisation;

  @Column(name = "extra_entropy", length = 64)
  @Hash32Type
  private String extraEntropy;

  @Column(name = "protocol_major", nullable = false)
  @Word31Type
  private Integer protocolMajor;

  @Column(name = "protocol_minor", nullable = false)
  @Word31Type
  private Integer protocolMinor;

  @Column(name = "min_utxo_value", nullable = false, precision = 20)
  @Lovelace
  @Digits(integer = 20, fraction = 0)
  private BigDecimal minUtxoValue;

  @Column(name = "min_pool_cost", nullable = false, precision = 20)
  @Lovelace
  @Digits(integer = 20, fraction = 0)
  private BigDecimal minPoolCost;

  @Column(name = "nonce", length = 64)
  @Hash32Type
  private String nonce;

  @Column(name = "coins_per_utxo_size", precision = 20)
  @Lovelace
  @Digits(integer = 20, fraction = 0)
  private BigDecimal coinsPerUtxoSize;

  @ManyToOne(fetch = FetchType.LAZY)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "cost_model_id",
      foreignKey = @ForeignKey(name = "epoch_param_cost_model_id_fkey"))
  @EqualsAndHashCode.Exclude
  private CostModel costModel;

  @Column(name = "price_mem")
  private Double priceMem;

  @Column(name = "price_step")
  private Double priceStep;

  @Column(name = "max_tx_ex_mem", precision = 20)
  @Word64Type
  @Digits(integer = 20, fraction = 0)
  private BigDecimal maxTxExMem;

  @Column(name = "max_tx_ex_steps", precision = 20)
  @Word64Type
  @Digits(integer = 20, fraction = 0)
  private BigDecimal maxTxExSteps;

  @Column(name = "max_block_ex_mem", precision = 20)
  @Word64Type
  @Digits(integer = 20, fraction = 0)
  private BigDecimal maxBlockExMem;

  @Column(name = "max_block_ex_steps", precision = 20)
  @Word64Type
  @Digits(integer = 20, fraction = 0)
  private BigDecimal maxBlockExSteps;

  @Column(name = "max_val_size", precision = 20)
  @Word64Type
  @Digits(integer = 20, fraction = 0)
  private BigDecimal maxValSize;

  @Column(name = "collateral_percent")
  @Word31Type
  private Integer collateralPercent;

  @Column(name = "max_collateral_inputs")
  @Word31Type
  private Integer maxCollateralInputs;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "block_id", nullable = false,
      foreignKey = @ForeignKey(name = "epoch_param_block_id_fkey"))
  @EqualsAndHashCode.Exclude
  private Block block;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    EpochParam that = (EpochParam) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
