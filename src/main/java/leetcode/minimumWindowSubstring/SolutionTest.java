package main.java.leetcode.minimumWindowSubstring;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution;
    @BeforeEach
    void init(){
        this.solution = new Solution();
    }

    @Test
    void minWindowTest(){
        assertEquals("BANC", this.solution.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("a", this.solution.minWindow("a", "a"));
        assertEquals("", this.solution.minWindow("a", "aa"));
        assertEquals("aa", this.solution.minWindow("aa", "aa"));
        assertEquals("ab", this.solution.minWindow("bdab", "ab"));
    }

}