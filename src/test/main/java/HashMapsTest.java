package test.main.java;

import main.java.HashMaps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapsTest {
    private HashMaps hashMaps;

    @BeforeEach
    void setUp() {
        this.hashMaps = new HashMaps();
    }

    @Test
    @DisplayName("Two Sum")
    void twoSum() {
        assertTrue(hashMaps.twoSum(new int[]{1, 3, 8, 2}, 10));
        assertFalse(hashMaps.twoSum(new int[]{3, 9, 13, 7}, 8));
        assertTrue(hashMaps.twoSum(new int[]{4, 2, 6, 5, 2}, 4));
    }
    @Test
    @DisplayName("Two Sum With Map")
    void twoSumWithMap() {
        assertTrue(hashMaps.twoSumWithMap(new int[]{1, 3, 8, 2}, 10));
        assertFalse(hashMaps.twoSumWithMap(new int[]{3, 9, 13, 7}, 8));
        assertTrue(hashMaps.twoSumWithMap(new int[]{4, 2, 6, 5, 2}, 4));
    }

    @Test
    @DisplayName("Jewels and Stones")
    void jewelsAndStones(){
        assertEquals(hashMaps.jewelsAndStones("abc", "ac"), 2);
        assertEquals(hashMaps.jewelsAndStones("Af", "AaaddfFf"), 3);
        assertEquals(hashMaps.jewelsAndStones("AYOPD", "ayopd"), 0);
    }

    @Test
    @DisplayName("Valid Anagram")
    void validAnagram() {
        assertTrue(hashMaps.isValidAnagram("cat", "tac"));
        assertTrue(hashMaps.isValidAnagram("caat", "taac"));
        assertFalse(hashMaps.isValidAnagram("cat", "taac"));
        assertTrue(hashMaps.isValidAnagram("listen", "silent"));
        assertFalse(hashMaps.isValidAnagram("program", "function"));
    }
}