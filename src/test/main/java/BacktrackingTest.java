package test.main.java;

import main.java.Backtracking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BacktrackingTest {
    Backtracking backtracking;
    @BeforeEach
    void setUp() {
        this.backtracking = new Backtracking();
    }
    @Test
    @DisplayName("String Permutations")
    void stringPermutations(){
        Assertions.assertIterableEquals(Arrays.asList("C7W2", "C7w2", "c7W2", "c7w2"), this.backtracking.stringPermutations("c7w2"));
    }
    @Test
    @DisplayName("Generate Text Messages")
    void generateTextMessages(){
        Assertions.assertIterableEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), this.backtracking.generateTextMessages("23"));
    }
}