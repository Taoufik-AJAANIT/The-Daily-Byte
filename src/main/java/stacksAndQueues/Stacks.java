package main.java.stacksAndQueues;

import java.util.HashMap;

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
}
