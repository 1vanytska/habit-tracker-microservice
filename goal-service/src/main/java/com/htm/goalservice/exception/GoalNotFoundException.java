package com.htm.goalservice.exception;

public class GoalNotFoundException extends RuntimeException {
  public GoalNotFoundException(String message) {
    super(message);
  }
}
