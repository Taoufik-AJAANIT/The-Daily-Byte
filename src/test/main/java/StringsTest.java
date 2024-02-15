package test.main.java;

import main.java.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {

    private Strings strings;

    @BeforeEach
    void setUp() {
        strings = new Strings();
    }


    @Test
    @DisplayName("Reverse String")
    void reverseString() {
        assertEquals("Cat", strings.reverse("taC"));
        assertEquals("The Daily Byte", strings.reverse("etyB yliaD ehT"));
        assertEquals("civic", strings.reverse("civic"));
    }

    @Test
    @DisplayName("Valid Palindrome")
    void checkIfIsPalindrome() {
        assertTrue(strings.isPalindrome("level"));
        assertFalse(strings.isPalindrome("algorithm"));
        assertTrue(strings.isPalindrome("A man, a plan, a canal: Panama."));
    }

    @Test
    @DisplayName("Vacuum Cleaner Route")
    void checkIfIsCyclicTrajectory() {
        assertTrue(strings.isCyclicTrajectory("LR"));
        assertFalse(strings.isCyclicTrajectory("URURD"));
        assertTrue(strings.isCyclicTrajectory("RUULLDRD"));
    }

    @Test
    @DisplayName("Correct Capitalization\n")
    void checkIsIsCorrectlyCapitalized() {
        assertTrue(strings.isCorrectlyCapitalized("USA"));
        assertTrue(strings.isCorrectlyCapitalized("Calvin"));
        assertFalse(strings.isCorrectlyCapitalized("compUter"));
        assertTrue(strings.isCorrectlyCapitalized("coding"));
    }

    @Test
    @DisplayName("Add Binary")
    void addBinary() {
        assertEquals("101", strings.addBinary("100", "1"));
        assertEquals("100", strings.addBinary("11", "1"));
        assertEquals("1", strings.addBinary("1", "0"));
        assertEquals("1111110", strings.addBinary("111111", "111111"));
    }

    @Test
    @DisplayName("Longest Common Prefix\n")
    void longestCommonPrefix() {
        assertEquals("col", strings.longestCommonPrefix(new String[]{"colorado", "color", "cold"}));
        assertEquals("", strings.longestCommonPrefix(new String[]{"a", "b", "c"}));
        assertEquals("spot", strings.longestCommonPrefix(new String[]{"spot", "spotty", "spotted"}));
    }

    @Test
    @DisplayName("Valid PalindromeWithRemoval")
    void checkIfIsPalindromeWithRemoval() {
        assertTrue(strings.isPalindromeWithRemoval("abcba"));
        assertTrue(strings.isPalindromeWithRemoval("foobof"));
        assertFalse(strings.isPalindromeWithRemoval("abccab"));
    }
    @Test
    @DisplayName("Valid PalindromeWithRemoval Recursive")
    void checkIfIsPalindromeWithRemovalRecursive() {
        assertTrue(strings.isPalindromeWithRemovalRecursive("abcba"));
        assertTrue(strings.isPalindromeWithRemovalRecursive("foobof"));
        assertFalse(strings.isPalindromeWithRemovalRecursive("abccab"));
    }
}