package main.java;

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
        int horizontalBalance = 0;
        int verticalBalance = 0;
        for (int i = 0; i < trajectory.length(); i++) {
            if (trajectory.charAt(i) == 'R') {
                horizontalBalance = horizontalBalance + 1;
            }
            if (trajectory.charAt(i) == 'L') {
                horizontalBalance = horizontalBalance - 1;
            }
            if (trajectory.charAt(i) == 'T') {
                verticalBalance = verticalBalance + 1;
            }
            if (trajectory.charAt(i) == 'B') {
                verticalBalance = verticalBalance - 1;
            }
        }
        return verticalBalance == 0 && horizontalBalance == 0;
    }

    public boolean isCorrectlyCapitalized(String input) {
        if (input.toLowerCase().equals(input)) {
            return true;
        }
        if (input.toUpperCase().equals(input)) {
            return true;
        }
        return Character.toUpperCase(input.charAt(0)) == input.charAt(0)
                && input.substring(1, input.length() - 1).toLowerCase().equals(input.substring(1, input.length() - 1));
    }

    public String addBinary(String a, String b) {
        StringBuilder binaryResult = new StringBuilder();
        int carrying = 0;
        for (int aIterator = a.length() - 1, bIterator = b.length() - 1; bIterator >= 0 || aIterator >= 0; aIterator--, bIterator--) {
            int columnTotal = Integer.parseInt(String.valueOf(aIterator >= 0 ? a.charAt(aIterator) : "0"))
                    + Integer.parseInt(String.valueOf(bIterator >= 0 ? b.charAt(bIterator) : "0"))
                    + carrying;
            binaryResult.insert(0, columnTotal % 2);
            carrying = columnTotal / 2;
        }
        if (carrying == 1) {
            binaryResult.insert(0, 1);
        }
        return binaryResult.toString();
    }

    public String longestCommonPrefix(String[] matrix) {
        StringBuilder longestCommonPrefix = new StringBuilder();
        char currentLetter;
        for (int horizentalIterator = 0; horizentalIterator < matrix[0].length(); horizentalIterator++) {
            currentLetter = matrix[0].charAt(horizentalIterator);
            for (int verticalIterator = 1; verticalIterator < matrix.length; verticalIterator++) {
                if (horizentalIterator >= matrix[verticalIterator].length()
                        || matrix[verticalIterator].charAt(horizentalIterator) != currentLetter) {
                    return longestCommonPrefix.toString();
                }
            }
            longestCommonPrefix.append(currentLetter);
        }
        return longestCommonPrefix.toString();
    }

    public boolean isPalindromeWithRemoval(String input) {
        int removalCount = 0;
        for (int iterator = 0, reverseIterator = input.length() - 1; iterator <= reverseIterator; ) {
            if (input.charAt(iterator) != input.charAt(reverseIterator)) {
                if (removalCount == 1) {
                    return false;
                }
                if (input.charAt(iterator + 1) == input.charAt(reverseIterator)) {
                    iterator = iterator + 1;
                    removalCount = removalCount + 1;
                } else if (input.charAt(reverseIterator - 1) == input.charAt(iterator)) {
                    reverseIterator = reverseIterator - 1;
                    removalCount = removalCount + 1;
                }
            } else {
                reverseIterator = reverseIterator - 1;
                iterator = iterator + 1;
            }
        }
        return true;
    }
    public boolean isPalindromeWithRemovalRecursive(String input) {
        for (int iterator = 0, reverseIterator = input.length() - 1; iterator <= reverseIterator; iterator++, reverseIterator--) {
            if (input.charAt(iterator) != input.charAt(reverseIterator)) {
                return this.isPalindrome(input.substring(iterator + 1, (reverseIterator) + 1))
                        || isPalindrome(input.substring(iterator, (reverseIterator - 1) + 1));
            }
        }
        return true;
    }
}
