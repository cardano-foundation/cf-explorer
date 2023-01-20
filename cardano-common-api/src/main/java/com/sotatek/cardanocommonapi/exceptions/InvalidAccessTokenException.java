package com.sotatek.cardanocommonapi.exceptions;

import com.sotatek.cardanocommonapi.exceptions.base.AbstractTokenException;
import com.sotatek.cardanocommonapi.exceptions.enums.CommonErrorCode;

public class InvalidAccessTokenException extends AbstractTokenException {

  public InvalidAccessTokenException() {
    super(CommonErrorCode.INVALID_TOKEN);
  }
}
