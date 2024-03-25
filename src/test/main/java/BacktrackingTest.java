package test.main.java;

import main.java.Backtracking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    @Test
    @DisplayName("Word Search")
    void wordSearch(){
        char[][] board = new char[][]{
                {'C','A','T','F'},
                {'B','G','E','S'},
                {'I','T','A','E'}
        };
        assertTrue(this.backtracking.wordSearch(board, "CAT"));
        assertTrue(this.backtracking.wordSearch(board, "TEA"));
        assertTrue(this.backtracking.wordSearch(board, "TEAE"));
        assertTrue(this.backtracking.wordSearch(board, "SEAT"));
        assertFalse(this.backtracking.wordSearch(board, "BAT"));

        char[][] board2 = new char[][]{
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        assertTrue(this.backtracking.wordSearch(board2, "ABCESEEEFS"));
    }
}