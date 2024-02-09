package main.java;

import java.util.ArrayList;
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

    public boolean isValidAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (sMap.get(t.charAt(i)) == null || sMap.get(t.charAt(i)) == 0) {
                return false;
            }
            sMap.put(t.charAt(i), sMap.get(t.charAt(i)) - 1);
        }
        return true;
    }

    public int firstUniqueCharacter(String input) {
        Map<Character, Integer> charactersMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            charactersMap.put(input.charAt(i), charactersMap.getOrDefault(input.charAt(i), 0) + 1);
        }
        for (int i = 0; i < input.length(); i++) {
            if (charactersMap.get(input.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public char spotTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.get(t.charAt(i)) == null || map.get(t.charAt(i)) == 0) {
                return t.charAt(i);
            }
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        }
        return ' ';
    }

    public int[] intersection(int[] ints, int[] ints1) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int anInt : ints) {
            map.put(anInt, 1);
        }
        for (int j : ints1) {
            if (map.getOrDefault(j, 0) > 0) {
                result.add(j);
                map.put(j, map.get(j) - 1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public String[] uncommonWords(String s, String t) {
        ArrayList<String> result = new ArrayList<>();
        Map<String, Integer> smap = new HashMap<>();
        Map<String, Integer> tmap = new HashMap<>();
        for (String word : t.split(" ")) {
            tmap.put(word, tmap.getOrDefault(word, 0) + 1);
        }
        for (String word : s.split(" ")) {
            smap.put(word, smap.getOrDefault(word, 0) + 1);
        }
        for (String word : t.split(" ")) {
            if (smap.get(word) == null && tmap.get(word) == 1) {
                result.add(word);
            }
        }
        for (String word : s.split(" ")) {
            if (tmap.get(word) == null && smap.get(word) == 1) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
