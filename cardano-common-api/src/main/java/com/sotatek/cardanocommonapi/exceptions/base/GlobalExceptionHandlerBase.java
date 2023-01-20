package com.sotatek.cardanocommonapi.exceptions.base;

import com.sotatek.cardanocommonapi.exceptions.AccessTokenExpireException;
import com.sotatek.cardanocommonapi.exceptions.BusinessException;
import com.sotatek.cardanocommonapi.exceptions.ErrorResponse;
import com.sotatek.cardanocommonapi.exceptions.IgnoreRollbackException;
import com.sotatek.cardanocommonapi.exceptions.InvalidAccessTokenException;
import com.sotatek.cardanocommonapi.exceptions.TokenRefreshException;
import com.sotatek.cardanocommonapi.exceptions.enums.CommonErrorCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log4j2
public class GlobalExceptionHandlerBase {

  @ExceptionHandler({BusinessException.class})
  public ResponseEntity<ErrorResponse> handleException(BusinessException e) {
    log.warn("Business logic exception: {}, stack trace:", e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
        ErrorResponse.builder().errorCode(e.getErrorCode()).errorMessage(e.getErrorMsg()).build());
  }

  @ExceptionHandler({IgnoreRollbackException.class})
  public ResponseEntity<ErrorResponse> handleException(IgnoreRollbackException e) {
    log.warn("No rollback exception: {}, stack trace:", e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
        ErrorResponse.builder().errorCode(e.getErrorCode()).errorMessage(e.getErrorMsg()).build());
  }

  @ExceptionHandler({Exception.class})
  public ResponseEntity<ErrorResponse> handleException(Exception e) {
    log.warn("Unknown exception: {}, stack trace:", e.getMessage());
    return new ResponseEntity<>(
        ErrorResponse.builder().errorCode(CommonErrorCode.UNKNOWN_ERROR.getServiceErrorCode())
            .errorMessage(CommonErrorCode.UNKNOWN_ERROR.getDesc()).build(),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler({TokenRefreshException.class})
  public ResponseEntity<ErrorResponse> handleAuthException(TokenRefreshException e) {
    log.warn("Refresh token exception: {}, stack trace:", e.getMessage());
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
        ErrorResponse.builder().errorCode(e.getErrorCode().getServiceErrorCode())
            .errorMessage(e.getErrorCode().getDesc()).build());
  }

  @ExceptionHandler({AccessTokenExpireException.class})
  public ResponseEntity<ErrorResponse> handleAuthException(AccessTokenExpireException e) {
    log.warn("Access token expired: {}, stack trace:", e.getMessage());
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
        ErrorResponse.builder().errorCode(e.getErrorCode().getServiceErrorCode())
            .errorMessage(e.getErrorCode().getDesc()).build());
  }

  @ExceptionHandler({InvalidAccessTokenException.class})
  public ResponseEntity<ErrorResponse> handleAuthException(InvalidAccessTokenException e) {
    log.warn("Invalid access token: {}", e.getErrorCode());
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
        ErrorResponse.builder().errorCode(e.getErrorCode().getServiceErrorCode())
            .errorMessage(e.getErrorCode().getDesc()).build());
  }
}
