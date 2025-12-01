package com.gmail.coserariualain.adventofcode2025.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class SolverPartTwo {
  private final String filePath;
  private final Dial dial = new Dial();

  public SolverPartTwo(String filePath) {
    Objects.requireNonNull(filePath);

    this.filePath = filePath;
  }

  private int solve(BufferedReader reader) throws IOException {
    int result = 0;
    var lines = reader.readAllLines();

    for (var line : lines) {
      int oldPos = dial.dialPosition();

      int nbClick = Integer.parseInt(line.substring(1));

      if (line.startsWith("L")) {
        if (oldPos - nbClick <= 0) {
          if (oldPos > 0) {
            result += 1;
          }
          result += Math.abs((oldPos - nbClick) / 100);
        }
        dial.turnLeft(nbClick);
      } else {
        if (oldPos + nbClick >= 100) {
          result += Math.abs((oldPos + nbClick) / 100);
        }
        dial.turnRight(nbClick);
      }
    }
    return result;
  }

  public int solve() throws IOException {
    try (var inputStream = SolverPartTwo.class.getResourceAsStream(filePath)) {
      if (inputStream == null) {
        throw new IOException("File not found: " + filePath);
      }

      try (var reader = new BufferedReader(new InputStreamReader(inputStream))) {
        return solve(reader);
      }
    }
  }

  static void main() throws IOException {
    var filePath = "input";
    var solver = new SolverPartTwo(filePath);
    IO.println(solver.solve());
  }
}
