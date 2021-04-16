package com.revature.exceptions;

/** Tie Exception - An exception to be thrown when a tie occurs */
public class TieException extends Exception {

  /** @param msg - The message of the exception */
  public TieException(String msg) {
    super(msg);
  }
}
