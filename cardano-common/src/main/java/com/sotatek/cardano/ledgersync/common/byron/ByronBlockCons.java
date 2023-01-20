package com.sotatek.cardano.ledgersync.common.byron;

import com.sotatek.cardano.ledgersync.common.Epoch;
import com.sotatek.cardano.ledgersync.common.byron.signature.BlockSignature;
import lombok.*;

import java.math.BigInteger;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class ByronBlockCons {

  private Epoch slotId;
  private String pubKey;
  private BigInteger difficulty;
  private BlockSignature blockSig;
}
