package com.sotatek.cardano.ledgersync.common.byron.payload;

import com.sotatek.cardano.ledgersync.common.SoftwareVersion;
import com.sotatek.cardano.ledgersync.common.byron.ByronBlockVersion;
import com.sotatek.cardano.ledgersync.common.byron.ByronBlockVersionMod;
import com.sotatek.cardano.ledgersync.common.byron.ByronUpdateData;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class ByronUpdateProposal {
  private ByronBlockVersion blockVersion;
  private ByronBlockVersionMod blockVersionMod;
  private SoftwareVersion softwareVersion;
  private Map<String, ByronUpdateData> data;
  private String attributes;
  private String from;
  private String signature;
}
