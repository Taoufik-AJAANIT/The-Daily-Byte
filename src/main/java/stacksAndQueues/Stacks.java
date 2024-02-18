package main.java.stacksAndQueues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stacks {

    public boolean isValidCharacters(String s) throws Exception {
        HashMap<Character, Character> equivalents = new HashMap<>();
        equivalents.put(')', '(');
        equivalents.put('}', '{');
        equivalents.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (equivalents.get(c) == null) {
                stack.push(c);
            } else {
                if (equivalents.get(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean compareKeystrokes(String s, String t) throws Exception {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#' && !stackS.isEmpty()) {
                stackS.pop();
            } else if (c != '#') {
                stackS.push(c);
            }
        }
        for (char c : t.toCharArray()) {
            if (c == '#' && !stackT.isEmpty()) {
                stackT.pop();
            } else if (c != '#') {
                stackT.push(c);
            }
        }
        while (!stackS.isEmpty() && !stackT.isEmpty()) {
            if (stackS.pop() != stackT.pop()) {
                return false;
            }
        }
        return stackT.isEmpty() && stackS.isEmpty();
    }

    public String removeAdjacentDuplicates(String s) throws Exception {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.peek() != null && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }

    public int[] greaterElements(int[] nums1, int[] nums2) throws Exception {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        for (int i = nums2.length - 1; i >= 0; i--) {
            int nextGreatest = -1;
            if (stack.isEmpty()) {
                stack.push(nums2[i]);
            } else {
                if (stack.peek() > nums2[i]) {
                    nextGreatest = stack.peek();
                    stack.push(nums2[i]);
                } else {
                    while (!stack.isEmpty() && nextGreatest == -1) {
                        if (stack.peek() > nums2[i]) {
                            nextGreatest = stack.peek();
                        }else {
                            stack.pop();
                        }
                    }
                    stack.push(nums2[i]);
                }
            }
            if (map.get(nums2[i]) != null) {
                result[map.get(nums2[i])] = nextGreatest;
            }
        }
        return result;
    }
}
