package com.gmail.coserariualain.adventofcode2025.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public class Solver {
    private final String input;

    public Solver(String input) {
        Objects.requireNonNull(input);
        this.input = input;
    }

    private long solve(BufferedReader reader, Predicate<Long> isIdValid) throws IOException {
        var ranges = reader.readLine().split(",");
        return Arrays.stream(ranges)
                .map(strRange -> {
                    var bounds = strRange.split("-");
                    return new RangeId(Long.parseLong(bounds[0]), Long.parseLong(bounds[1]));
                })
                .flatMapToLong(range -> range.invalidIds(isIdValid).stream().mapToLong(i ->i))
                .sum();
    }

    public long solve(Predicate<Long> isIdValid) throws IOException {
        try (var inputStream = Solver.class.getResourceAsStream(input)) {
            if (inputStream == null) {
                throw new IOException("File not found: " + input);
            }

            try(var reader = new BufferedReader(new InputStreamReader(inputStream))) {
                return solve(reader, isIdValid);
            }
        }
    }

    static void main() throws IOException {
        var solver = new Solver("input.txt");
        IO.println(solver.solve(RangeId::repeat2Times));
    }
}
