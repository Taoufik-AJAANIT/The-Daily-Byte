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

    public boolean compareKeystrokes(String s, String t) throws Exception {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#' && !stackS.isEmpty()) {
                stackS.pop();
            }  else if(c != '#') {
                stackS.push(c);
            }
        }
        for (char c : t.toCharArray()) {
            if (c == '#' && !stackT.isEmpty()) {
                stackT.pop();
            } else if(c != '#') {
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
}
