package main.java;

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
        ;
        return twoSumFromIndex(array, k, index + 1);
    }
}
