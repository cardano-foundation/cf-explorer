package com.sotatek.cardano.ledgersync.common.certs;

import com.sotatek.cardano.ledgersync.common.PoolParams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class PoolRegistration extends Certificate {

    private static final CertType type = CertType.POOL_REGISTRATION;

    private PoolParams poolParams;

    @Override
    public CertType getCertType() {
        return type;
    }
}
