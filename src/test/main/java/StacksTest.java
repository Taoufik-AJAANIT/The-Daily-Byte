package test.main.java;

import main.java.stacksAndQueues.Stacks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StacksTest {
    private Stacks stacks;

    @BeforeEach
    void setUp() {
        stacks = new Stacks();
    }

    @Test
    @DisplayName("Validate Characters")
    void checkIfIsPalindrome() throws Exception {
        assertTrue(stacks.isValidCharacters("(){}[]"));
        assertFalse(stacks.isValidCharacters("(){}[])"));
        assertFalse(stacks.isValidCharacters("(){}[]("));
        assertTrue(stacks.isValidCharacters("(({[]}))"));
        assertFalse(stacks.isValidCharacters("{(})"));
    }

    @Test
    @DisplayName("Compare Keystrokes")
    void compareKeystrokes() throws Exception {
        assertTrue(stacks.compareKeystrokes("ABC#", "CD##AB"));
        assertTrue(stacks.compareKeystrokes("como#pur#ter", "computer"));
        assertFalse(stacks.compareKeystrokes("cof#dim#ng", "code"));
        assertTrue(stacks.compareKeystrokes("y#fo##f", "y#f#o##f"));

    }

    @Test
    @DisplayName("Remove Adjacent Duplicates")
    void removeAdjacentDuplicates() throws Exception {
        assertEquals("", stacks.removeAdjacentDuplicates("abccba"));
        assertEquals("fbar", stacks.removeAdjacentDuplicates("foobar"));
        assertEquals("a", stacks.removeAdjacentDuplicates("abccbefggfe"));
        assertEquals("ca", stacks.removeAdjacentDuplicates("abbaca"));

    }
}