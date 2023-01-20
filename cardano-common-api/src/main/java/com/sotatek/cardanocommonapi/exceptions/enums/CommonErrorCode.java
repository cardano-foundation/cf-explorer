package com.sotatek.cardanocommonapi.exceptions.enums;

public enum CommonErrorCode implements ErrorCode {

  UNKNOWN_ERROR("1", "Unknown error"), INVALID_TOKEN("2",
      "The access token is invalid"), TOKEN_EXPIRED("3",
      "The access token is expired"), REFRESH_TOKEN_EXPIRED("4",
      "The refresh token is expired"), SIGNATURE_INVALID("5",
      "The signature is invalid"), USER_IS_NOT_EXIST("6", "User is not exist"), NONCE_EXPIRED("7",
      "The nonce is expired. Please take new nonce"), ROLE_IS_NOT_FOUND("8",
      "The role is not found"), REFRESH_TOKEN_IS_NOT_EXIST("9",
      "The refresh token is not exist"), TOKEN_INVALID_SIGNATURE("10",
      "The signature access token is invalid"), TOKEN_UNSUPPORTED("11",
      "The access token is unsupported"), TOKEN_IS_NOT_EMPTY("12",
      "The access token is not empty"), PARAM_IS_NOT_NULL("13",
      "The parameter is not null"), LIMIT_BOOKMARK_IS_2000("14",
      "Bookmarks do not exceed 2000 records"), LIMIT_NOTE_IS_2000("15",
      "Private note do not exceed 2000 records"), BOOKMARK_IS_EXIST("16",
      "Bookmark is already exists"), PRIVATE_NOTE_IS_EXIST("17",
      "Private note is already exists"), WALLET_IS_NOT_EXIST("18",
      "Wallet is not linked to account yet"), USERNAME_IS_ALREADY_EXIST("19",
      "Username is already exist"), WALLET_IS_ALREADY_EXIST("20",
      "Wallet is already exist"), INVALID_VERIFY_CODE("21",
      "The verify code is invalid"), VERIFY_CODE_NOT_PENDING("22",
      "User is not ready to active"), EMAIL_IS_ALREADY_EXIST("23",
      "Email is already exist"), USERNAME_OR_PASSWORD_INVALID("24",
      "Username or password is invalid");

  private final String code;
  private final String desc;

  private CommonErrorCode(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  @Override
  public String getCode() {
    return this.code;
  }

  @Override
  public String getDesc() {
    return this.desc;
  }

  @Override
  public String getServicePrefix() {
    return "CC";
  }
}
