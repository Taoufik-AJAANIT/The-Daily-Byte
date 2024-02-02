package main.java;

import java.util.HashMap;
import java.util.Map;

public class HashMaps {
    public boolean twoSum(int[] array, int k) {
        return twoSumFromIndex(array, k, 0);
    }

    private boolean twoSumFromIndex(int[] array, int k, int index) {
        int remainingElementsCount = array.length - index;
        if (remainingElementsCount < 2) {
            return false;
        }
        for (int i = index + 1; i < array.length; i++) {
            if ((array[index] + array[i]) == k) {
                return true;
            }
        }
        return twoSumFromIndex(array, k, index + 1);
    }

    public boolean twoSumWithMap(int[] array, int k) {
        Map<Integer, Integer> differences = new HashMap<>();
        for (int element : array) {
            if (differences.get(element) != null) {
                return true;
            }
            int difference = k - element;
            differences.put(difference, element);
        }
        return false;
    }

    public int jewelsAndStones(String jewels, String stones) {
        int count = 0;
        Map<Character, Integer> jewelsMap = new HashMap<>();
        for (int i = 0; i < jewels.length(); i++) {
            jewelsMap.put(jewels.charAt(i), 0);
        }
        for (int j = 0; j < stones.length(); j++) {
            if (jewelsMap.get(stones.charAt(j)) != null) {
                count = count + 1;
            }
        }
        return count;
    }
}
