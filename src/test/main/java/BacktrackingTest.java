package test.main.java;

import main.java.Backtracking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BacktrackingTest {
    Backtracking backtracking;

    @BeforeEach
    void setUp() {
        this.backtracking = new Backtracking();
    }

    @Test
    @DisplayName("String Permutations")
    void stringPermutations() {
        Assertions.assertIterableEquals(Arrays.asList("C7W2", "C7w2", "c7W2", "c7w2"), this.backtracking.stringPermutations("c7w2"));
    }

    @Test
    @DisplayName("Generate Text Messages")
    void generateTextMessages() {
        Assertions.assertIterableEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), this.backtracking.generateTextMessages("23"));
    }

    @Test
    @DisplayName("Word Search")
    void wordSearch() {
        char[][] board = new char[][]{
                {'C', 'A', 'T', 'F'},
                {'B', 'G', 'E', 'S'},
                {'I', 'T', 'A', 'E'}
        };
        assertTrue(this.backtracking.wordSearch(board, "CAT"));
        assertTrue(this.backtracking.wordSearch(board, "TEA"));
        assertTrue(this.backtracking.wordSearch(board, "TEAE"));
        assertTrue(this.backtracking.wordSearch(board, "SEAT"));
        assertFalse(this.backtracking.wordSearch(board, "BAT"));

        char[][] board2 = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        assertTrue(this.backtracking.wordSearch(board2, "ABCESEEEFS"));
    }

    @Test
    @DisplayName("Gold Rush")
    void goldRush() {
        int[][] board = new int[][]{
                {0, 2, 0},
                {8, 6, 3},
                {0, 9, 0}
        };
        assertEquals(23, this.backtracking.goldRush(board));
    }

    @Test
    @DisplayName("Parentheses Generation")
    void parenthesesGeneration() {
        List<String> result = new ArrayList<>(
                Arrays.asList(
                        "()()()",
                        "(()())",
                        "()(())",
                        "((()))",
                        "(())()"
                )
        );
        Assertions.assertIterableEquals(result, this.backtracking.parenthesesGeneration(3));
        List<String> result2 = new ArrayList<>(
                Arrays.asList(
                        "()()()()",
                        "(()(()))",
                        "(()())()",
                        "()()(())",
                        "(((())))",
                        "(())()()",
                        "()((()))",
                        "()(())()",
                        "()(()())",
                        "(()()())",
                        "((()()))",
                        "((()))()",
                        "((())())"
                )
        );

        Assertions.assertIterableEquals(result2, this.backtracking.parenthesesGeneration(4));
    }

    @Test
    @DisplayName("Parentheses Generation 2")
    void parenthesesGeneration2() {
        List<String> result = new ArrayList<>(
                Arrays.asList(
                        "((()))",
                        "(()())",
                        "(())()",
                        "()(())",
                        "()()()"
                )
        );
        Assertions.assertIterableEquals(result, this.backtracking.parenthesesGeneration2(3));
        List<String> result2 = new ArrayList<>(
                Arrays.asList(
                        "(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"
                )
        );
        Assertions.assertIterableEquals(result2, this.backtracking.parenthesesGeneration2(4));
    }
    @Test
    @DisplayName("Unique Combinations")
    void uniqueCombinations() {
        List<List<Integer>> result = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(2, 2, 2),
                        Arrays.asList(2, 4),
                        Arrays.asList(6),
                        Arrays.asList(3, 3)
                )
        );
        Assertions.assertIterableEquals(result, this.backtracking.uniqueCombinations(new int[]{2, 4, 6, 3}, 6));
    }
}