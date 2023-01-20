package com.sotatek.cardanocommonapi.exceptions;

import com.sotatek.cardanocommonapi.exceptions.base.AbstractTokenException;
import com.sotatek.cardanocommonapi.exceptions.enums.CommonErrorCode;

public class AccessTokenExpireException extends AbstractTokenException {

  public AccessTokenExpireException() {
    super(CommonErrorCode.TOKEN_EXPIRED);
  }
}
