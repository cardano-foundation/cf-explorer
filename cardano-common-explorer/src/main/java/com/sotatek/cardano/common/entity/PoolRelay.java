package com.sotatek.cardano.common.entity;

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
@Table(name = "pool_relay", uniqueConstraints = {
    @UniqueConstraint(name = "unique_pool_relay",
        columnNames = {"update_id", "ipv4", "ipv6", "dns_name"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class PoolRelay extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "update_id", nullable = false,
      foreignKey = @ForeignKey(name = "pool_relay_update_id_fkey"))
  @EqualsAndHashCode.Exclude
  private PoolUpdate poolUpdate;

  @Column(name = "ipv4")
  private String ipv4;

  @Column(name = "ipv6")
  private String ipv6;

  @Column(name = "dns_name")
  private String dnsName;

  @Column(name = "dns_srv_name")
  private String dnsSrvName;

  @Column(name = "port")
  private Integer port;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    PoolRelay poolRelay = (PoolRelay) o;
    return id != null && Objects.equals(id, poolRelay.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
