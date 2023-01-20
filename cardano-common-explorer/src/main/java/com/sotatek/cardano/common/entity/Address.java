package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.validation.Word128Type;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Where(clause = "is_deleted = false")
public class Address extends BaseEntity{
  @Column(name = "address", nullable = false, length = 65535)
  private String address;

  @Column(name = "tx_count")
  private Long txCount;

  @Column(name = "balance", nullable = false, precision = 39)
  @Word128Type
  @Digits(integer = 39, fraction = 0)
  private BigDecimal balance;

  @Column(name = "address_has_script", nullable = false)
  private Boolean addressHasScript;

  @ManyToOne(fetch = FetchType.LAZY)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "stake_address_id",
      foreignKey = @ForeignKey(name = "address_stake_address_id_fkey"))
  private StakeAddress stakeAddress;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Address address = (Address) o;
    return id != null && Objects.equals(id, address.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
