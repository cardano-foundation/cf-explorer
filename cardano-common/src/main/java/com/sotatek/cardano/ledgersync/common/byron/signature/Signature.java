package com.sotatek.cardano.ledgersync.common.byron.signature;

import co.nstant.in.cbor.model.Array;
import co.nstant.in.cbor.model.ByteString;
import co.nstant.in.cbor.model.DataItem;
import com.sotatek.cardano.ledgersync.util.HexUtil;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Signature implements  BlockSignature{

  private String blockSignature;

  @Override
  public String getType() {
    return ByronSigType.SIGNATURE;
  }

  public static com.sotatek.cardano.ledgersync.common.byron.signature.Signature deserialize(DataItem dataItem){
    List<DataItem> dataItems = ((Array) dataItem).getDataItems();

    String signature = HexUtil.encodeHexString((
        (ByteString)dataItems.get(0)).getBytes()
    );

    return com.sotatek.cardano.ledgersync.common.byron.signature.Signature.builder()
        .blockSignature(signature)
        .build();
  }
}
