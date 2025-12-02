package com.gmail.coserariualain.adventofcode2025.day2;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.LongStream;

public record RangeId(long begin, long end) {
    public static boolean repeat2Times(long id) {
        var idString = id + "";
        var firstHalf = idString.substring(0, idString.length() / 2);
        var secondHalf = idString.substring(idString.length()/2);
        return firstHalf.equals(secondHalf);
    }

    private static boolean isStringRepeated(String strToCheck, String pattern) {
        if (pattern.isEmpty()) {
            throw new IllegalArgumentException("empty pattern");
        }
        int i = 0;
        while (i+pattern.length() <= strToCheck.length()) {
            if (!strToCheck.startsWith(pattern, i)) {
                return false;
            }
            i += pattern.length();
        }
        return i == strToCheck.length();
    }

    public static boolean repeatNTimes(long id) {
        var idString = id + "";
        for (int i = 1; i <= idString.length() / 2; i++) {
            var subString = idString.substring(0, i);
            if (isStringRepeated(idString, subString)) return true;
        }
        return false;
    }

    public List<Long> invalidIds(Predicate<Long> isIdValid) {
        return LongStream.range(begin, end+1).filter(isIdValid::test).boxed().toList();
    }
}
