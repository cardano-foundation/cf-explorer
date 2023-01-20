package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.enumeration.ScriptType;
import com.sotatek.cardano.common.validation.Hash28Type;
import com.sotatek.cardano.common.validation.Word31Type;
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
@Table(name = "script", uniqueConstraints = {
    @UniqueConstraint(name = "unique_script", columnNames = {"hash"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Script extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "tx_id", nullable = false, foreignKey = @ForeignKey(name = "script_tx_id_fkey"))
  @EqualsAndHashCode.Exclude
  private Tx tx;

  @Column(name = "hash", nullable = false, length = 64)
  @Hash28Type
  private String hash;

  @Column(name = "type", nullable = false)
  private ScriptType type;

  //wip
  @Column(name = "json", length = 65535)
  private String json;

  @Column(name = "bytes")
  private byte[] bytes;

  @Column(name = "serialised_size")
  @Word31Type
  private Integer serialisedSize;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Script script = (Script) o;
    return id != null && Objects.equals(id, script.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
