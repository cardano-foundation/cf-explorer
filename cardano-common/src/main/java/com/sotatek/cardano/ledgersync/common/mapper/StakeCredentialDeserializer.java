package com.sotatek.cardano.ledgersync.common.mapper;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sotatek.cardano.ledgersync.common.certs.StakeCredential;
import java.io.IOException;

public class StakeCredentialDeserializer extends KeyDeserializer {


  @Override
  public Object deserializeKey(String s, DeserializationContext deserializationContext)
      throws IOException {
    return new ObjectMapper().readValue(s, StakeCredential.class);
  }
}
