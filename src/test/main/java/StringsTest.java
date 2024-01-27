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
    ;

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
}