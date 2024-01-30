package main.java;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Strings {
    public String reverse(String input) {
        char[] reversed = new char[input.length()];
        for (int i = 0, j = input.length() - 1; i <= j; i++, j--) {
            reversed[j] = input.charAt(i);
            reversed[i] = input.charAt(j);
        }
        return String.valueOf(reversed);
    }

    public boolean isPalindrome(String input) {
        for (int i = 0, j = input.length() - 1; i != j; ) {
            if (!Character.isAlphabetic(input.charAt(i))) {
                i = i + 1;
            } else if (!Character.isAlphabetic(input.charAt(j))) {
                j = j - 1;
            } else if (Character.toLowerCase(input.charAt(i)) == Character.toLowerCase(input.charAt(j))) {
                i = i + 1;
                j = j - 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isCyclicTrajectory(String trajectory) {
        int numberOfRights = this.countOccurrencesOf(trajectory, 'R');
        int numberOfLefts = this.countOccurrencesOf(trajectory, 'L');
        int numberOfTops = this.countOccurrencesOf(trajectory, 'T');
        int numberOfBottoms = this.countOccurrencesOf(trajectory, 'B');
        if (numberOfRights == numberOfLefts && numberOfBottoms == numberOfTops) {
            return true;
        }
        return false;
    }

    private int countOccurrencesOf(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count = count + 1;
            }
        }
        ;
        return count;
    }

    public boolean isCorrectlyCapitalized(String input) {
        if (input.toLowerCase().equals(input)) {
            return true;
        }
        if (input.toUpperCase().equals(input)) {
            return true;
        }
        if (Character.toUpperCase(input.charAt(0)) == input.charAt(0) && input.substring(1, input.length() - 1).toLowerCase().equals(input.substring(1, input.length() - 1))) {
            return true;
        }
        return false;
    }

    public String addBinary(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());
        int[] binaryResult = new int[maxLength];
        int carrying = 0;
        for (int aIterator = a.length() - 1, bIterator = b.length() - 1; bIterator >= 0 || aIterator >= 0; aIterator--, bIterator--) {
            int columnTotal = Integer.parseInt(String.valueOf(aIterator >= 0 ? a.charAt(aIterator) : "0"))
                    + Integer.parseInt(String.valueOf(bIterator >= 0 ? b.charAt(bIterator) : "0"))
                    + carrying;
            int maxIterator = Math.max(aIterator, bIterator);
            if (columnTotal == 3) {
                binaryResult[maxIterator] = 1;
                carrying = 1;
            } else if (columnTotal == 2) {
                binaryResult[maxIterator] = 0;
                carrying = 1;
            } else {
                binaryResult[maxIterator] = columnTotal;
                carrying = 0;
            }
        }
        if (carrying == 1) {
            return "1" + IntStream.of(binaryResult)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(""));
        }
        return IntStream.of(binaryResult)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(""));
    }
}
