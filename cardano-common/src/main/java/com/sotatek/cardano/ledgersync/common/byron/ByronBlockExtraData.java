package com.sotatek.cardano.ledgersync.common.byron;

import com.sotatek.cardano.ledgersync.common.BlockVersion;
import com.sotatek.cardano.ledgersync.common.SoftwareVersion;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class ByronBlockExtraData<T> {

  private BlockVersion blockVersion;
  private SoftwareVersion softwareVersion;
  private T attributes;
  private String extraProof;
}
