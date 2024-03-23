package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Backtracking {

    public List<String> stringPermutations(String input) {
        List<String> result = new ArrayList<>();
        generateStringPermutations(input, result, 0, "");
        return result;

    }

    void generateStringPermutations(String input, List<String> result, int index, String solution) {
        if (input.length() == 0) return;
        if (input.length() == index) {
            result.add(solution);
            return;
        }
        if (Character.isAlphabetic(input.charAt(index))){
            generateStringPermutations(input, result, index + 1, solution + Character.toUpperCase(input.charAt(index)));
            generateStringPermutations(input, result, index + 1, solution + Character.toLowerCase(input.charAt(index)));
        }else {
            generateStringPermutations(input, result, index + 1, solution + input.charAt(index));
        }
    }

    public Iterable<?> generateTextMessages(String input) {
        List<String> result = new ArrayList<>();
        HashMap<Character, String> keys = new HashMap<>();
        keys.put('2', "abc");
        keys.put('3', "def");
        keys.put('4', "ghi");
        keys.put('5', "jkl");
        keys.put('6', "mno");
        keys.put('7', "pqrs");
        keys.put('8', "tuv");
        keys.put('9', "wxyz");
        generateTextMessagesRec(input, result, 0, "", keys);
        return result;
    }

    void generateTextMessagesRec(String input, List result, int index, String solution, HashMap<Character, String> keys){
        if (input.length() == 0 ) return;
        if (input.length() == index) {
            result.add(solution);
            return;
        }
        for (int i = 0; i < keys.get(input.charAt(index)).length(); i++){
            generateTextMessagesRec(input, result, index + 1, solution + keys.get(input.charAt(index)).charAt(i), keys);
        }
    }
}
