package com.sotatek.cardanocommonapi.exceptions.base;

import com.sotatek.cardanocommonapi.exceptions.enums.CommonErrorCode;

public abstract class AbstractTokenException extends RuntimeException {

  private final CommonErrorCode errorCode;

  protected AbstractTokenException(CommonErrorCode errorCode) {
    this.errorCode = errorCode;
  }

  public CommonErrorCode getErrorCode() {
    return this.errorCode;
  }

  @Override
  public String toString() {
    return "AbstractTokenException{" + "errorCode=" + errorCode + '}';
  }
}
