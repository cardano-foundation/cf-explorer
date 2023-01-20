package com.sotatek.cardano.ledgersync.common.certs;

import com.sotatek.cardano.ledgersync.common.kafka.MapKey;
import com.sotatek.cardano.ledgersync.util.HexUtil;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@EqualsAndHashCode
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class StakeCredential extends MapKey {
    private StakeCredentialType stakeType;
    private String hash;

    public StakeCredential(StakeCredentialType stakeType, byte[] hashBytes) {
        this.stakeType = stakeType;
        if (hashBytes != null)
            this.hash = HexUtil.encodeHexString(hashBytes);
        else
            this.hash = null;
    }

    public StakeCredential(String stakeType, byte[] hashBytes) {
        this.stakeType = StakeCredentialType.valueOf(stakeType);
        if (hashBytes != null)
            this.hash = HexUtil.encodeHexString(hashBytes);
        else
            this.hash = null;
    }

}
