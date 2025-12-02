package com.gmail.coserariualain.adventofcode2025.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class Solver {
  private final String filePath;
  private final Dial dial = new Dial();

  public Solver(String filePath) {
    Objects.requireNonNull(filePath);

    this.filePath = filePath;
  }

  private int solve(InputStream in) throws IOException {
    try (var reader = new BufferedReader(new InputStreamReader(in))) {
      int nb0 = 0;
      var lines = reader.readAllLines();

      for (var line : lines) {
        int nbClick = Integer.parseInt(line.substring(1));
        if (line.startsWith("L")) {
          dial.turnLeft(nbClick);
        } else {
          dial.turnRight(nbClick);
        }

        if (dial.dialPosition() == 0) {
          nb0++;
        }
      }

      return nb0;
    }
  }

  public int solve() throws IOException {
    try (var inputStream = Solver.class.getResourceAsStream(filePath)) {
      if (inputStream == null) {
        throw new IOException("File not found: " + filePath);
      }

      return solve(inputStream);
    }
  }

  static void main() throws IOException {
    var filePath = "input.txt";
    var solver = new Solver(filePath);
    IO.println(solver.solve());
  }
}
