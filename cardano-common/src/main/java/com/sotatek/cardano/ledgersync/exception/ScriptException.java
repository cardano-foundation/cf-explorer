package com.sotatek.cardano.ledgersync.exception;

public class ScriptException extends RuntimeException{

  public ScriptException() {
    super();
  }

  public ScriptException(String message) {
    super(message);
  }

  public ScriptException(String message, Throwable cause) {
    super(message, cause);
  }
}
