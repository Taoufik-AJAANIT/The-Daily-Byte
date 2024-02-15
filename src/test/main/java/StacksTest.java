package test.main.java;

import main.java.stacksAndQueues.Stacks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(stacks.isValidCharacters("(({[]}))"));
        assertFalse(stacks.isValidCharacters("{(})"));
    }
}