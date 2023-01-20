package com.sotatek.cardano.common.entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = "id")
public class BaseEntity implements Serializable {

  @Id
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

/*  @Column(name = "created_at")
  @CreatedDate
  protected Timestamp createdAt;

  @Column(name = "updated_at")
  @LastModifiedDate
  protected Timestamp updatedAt;*/

  @Column(name = "is_deleted")
  @ColumnDefault("false")
  protected Boolean isDeleted = false;
}
