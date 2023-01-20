package com.sotatek.cardanocommonapi.exceptions;

import com.sotatek.cardanocommonapi.exceptions.base.AbstractTokenException;
import com.sotatek.cardanocommonapi.exceptions.enums.CommonErrorCode;

public class TokenRefreshException extends AbstractTokenException {

  public TokenRefreshException(CommonErrorCode commonErrorCode) {
    super(commonErrorCode);
  }
}
