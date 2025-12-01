package com.gmail.coserariualain.adventofcode2025.day1;

public class Dial {
  private int dialPosition = 50;

  public void turnRight(int n) {
    dialPosition = (dialPosition + n) % 100;
  }

  public void turnLeft(int n) {
    dialPosition = ((dialPosition - n) % 100 + 100) % 100;
  }

  public int dialPosition() {
    return dialPosition;
  }
}
