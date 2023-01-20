package com.sotatek.cardano.ledgersync.common.byron;

import com.sotatek.cardano.ledgersync.common.byron.payload.ByronDlgPayload;
import com.sotatek.cardano.ledgersync.common.byron.payload.ByronSscPayload;
import com.sotatek.cardano.ledgersync.common.byron.payload.ByronTxPayload;
import com.sotatek.cardano.ledgersync.common.byron.payload.ByronUpdatePayload;
import java.util.List;
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
public class ByronMainBody {
  private List<ByronTxPayload> txPayload;
  private ByronSscPayload sscPayload;
  private List<ByronDlgPayload> dlgPayload;
  private ByronUpdatePayload updPayload;
}
