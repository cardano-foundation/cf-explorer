package com.sotatek.cardanocommonapi.exceptions.enums;

public interface ErrorCode {

  String getCode();

  String getDesc();

  String getServicePrefix();

  default String getServiceErrorCode() {
    String var10000 = this.getServicePrefix();
    return var10000 + "_" + this.getCode();
  }
}
