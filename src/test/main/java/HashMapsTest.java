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
}