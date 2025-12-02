package com.gmail.coserariualain.adventofcode2025.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class SolverPartTwo {
    static void main() throws IOException {
        var solver = new Solver("input.txt");
        IO.println(solver.solve(RangeId::repeatNTimes));
    }
}
