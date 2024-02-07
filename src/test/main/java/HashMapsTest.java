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
    void jewelsAndStones() {
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

    @Test
    @DisplayName("First Unique Character")
    void firstUniqueCharacter() {
        assertEquals(hashMaps.firstUniqueCharacter("abcabd"), 2);
        assertEquals(hashMaps.firstUniqueCharacter("developer"), 0);
        assertEquals(hashMaps.firstUniqueCharacter("thedailybyte"), 1);
        assertEquals(hashMaps.firstUniqueCharacter("abccba"), -1);
    }
    @Test
    @DisplayName("Spot the Difference\n")
    void spotTheDifference() {
        assertEquals(hashMaps.spotTheDifference("foobar", "barfoot"), "t");
        assertEquals(hashMaps.spotTheDifference("ide", "idea"), "a");
        assertEquals(hashMaps.spotTheDifference("coding", "ingcod"), "");
    }

    @Test
    @DisplayName("Intersection of Numbers")
    void intersection() {
        assertArrayEquals(new int[]{2, 4}, hashMaps.intersection(new int[]{2, 4, 4, 2}, new int[]{2, 4}));
        assertArrayEquals(new int[]{3}, hashMaps.intersection(new int[]{1, 2, 3, 3}, new int[]{3, 3}));
        assertArrayEquals(new int[]{}, hashMaps.intersection(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8}));
    }
    @Test
    @DisplayName("Uncommon Words")
    void uncommonWords() {
        assertArrayEquals(new String[]{"the", "quick", "brown", "fox"}, hashMaps.uncommonWords("the quick", "brown fox"));
        assertArrayEquals(new String[]{"beat", "lost", "to"}, hashMaps.uncommonWords("the tortoise beat the haire", "the tortoise lost to the haire"));
        assertArrayEquals(new String[]{"copper", "hot"}, hashMaps.uncommonWords("copper coffee pot", "hot coffee pot"));
    }
}