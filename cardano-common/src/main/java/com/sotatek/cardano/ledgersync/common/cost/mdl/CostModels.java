package com.sotatek.cardano.ledgersync.common.cost.mdl;

import com.bloxbean.cardano.client.transaction.spec.Language;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class CostModels {
  private Map<Language, List<BigInteger>> costModel;
}
