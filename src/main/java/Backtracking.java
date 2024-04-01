package main.java;

import java.util.*;

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
        if (Character.isAlphabetic(input.charAt(index))) {
            generateStringPermutations(input, result, index + 1, solution + Character.toUpperCase(input.charAt(index)));
            generateStringPermutations(input, result, index + 1, solution + Character.toLowerCase(input.charAt(index)));
        } else {
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

    void generateTextMessagesRec(String input, List result, int index, String solution, HashMap<Character, String> keys) {
        if (input.length() == 0) return;
        if (input.length() == index) {
            result.add(solution);
            return;
        }
        for (int i = 0; i < keys.get(input.charAt(index)).length(); i++) {
            generateTextMessagesRec(input, result, index + 1, solution + keys.get(input.charAt(index)).charAt(i), keys);
        }
    }

    public boolean wordSearch(char[][] board, String input) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == input.charAt(0)) {
                    boolean found = wordSearchRec(board, input, 0, i, j);
                    if (found) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean wordSearchRec(char[][] board, String input, int index, int i, int j) {
        if (index == input.length()) {
            return true;
        }
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != input.charAt(index))
            return false;
        char temp = board[i][j];
        board[i][j] = '*';
        boolean found = wordSearchRec(board, input, index + 1, i + 1, j)
                || wordSearchRec(board, input, index + 1, i - 1, j)
                || wordSearchRec(board, input, index + 1, i, j + 1)
                || wordSearchRec(board, input, index + 1, i, j - 1);
        board[i][j] = temp;
        return found;
    }

    public int goldRush(int[][] board) {
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    sum = Math.max(goldRushRec(board, i, j, 0), sum);
                }
            }
        }
        return sum;
    }

    private int goldRushRec(int[][] board, int i, int j, int currentSum) {
        if (i < 0 || i >= board.length
                || j < 0 || j >= board[0].length
                || board[i][j] == 0) {
            return currentSum;
        }
        int temp = board[i][j];
        board[i][j] = 0;
        int result = Math.max(Math.max(
                        goldRushRec(board, i + 1, j, currentSum + temp),
                        goldRushRec(board, i - 1, j, currentSum + temp)
                ),
                Math.max(goldRushRec(board, i, j + 1, currentSum + temp),
                        goldRushRec(board, i, j - 1, currentSum + temp))
        );
        board[i][j] = temp;
        return result;
    }


    //        1 ()
    //        2 ()() (())
    //        3 (()()) ((())) ()()() ()(()) (())()
    public Set<String> parenthesesGeneration(int number) {
        Set<String> result = new HashSet<>();
        parenthesesGenerationRec(number, "", "", result);
        return result;
    }

    private void  parenthesesGenerationRec(int number, String prefix, String suffix, Set<String> result) {
        if (number == 1){
            result.add(prefix + "()" + suffix);
            return;
        }
        parenthesesGenerationRec(number - 1, "("  + prefix, ")" + suffix, result);
        parenthesesGenerationRec(number - 1, ""  + prefix, "()" + suffix, result);
        parenthesesGenerationRec(number - 1, "()" + prefix, "" + suffix, result);
    }

    public List<String> parenthesesGeneration2(int n) {
        List<String> res = new ArrayList<String>();
        parenthesesGenerationRec2(res, 0, 0, "", n);
        return res;
    }

    public void parenthesesGenerationRec2(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }

        if (left < n) {
            parenthesesGenerationRec2(res, left + 1, right, s + "(", n);
        }

        if (right < left) {
            parenthesesGenerationRec2(res, left, right + 1, s + ")", n);
        }
    }

    public List<List<Integer>> uniqueCombinations(int[] ints, int target) {
        List<List<Integer>> result = new ArrayList<>();
        uniqueCombinationsRec(result, ints, target, 0, new ArrayList<>(), 0);
        return result;

    }

    private void uniqueCombinationsRec(List<List<Integer>> result, int[] ints, int target, int sum, ArrayList<Integer> path, int index) {
        if (sum == target){
            result.add(path);
            return;
        }
        if (sum > target){
            return;
        }
        for (int i = index; i < ints.length; i++){
            ArrayList<Integer> newPath = new ArrayList<>(path);
            newPath.add(ints[i]);
            uniqueCombinationsRec(result, ints, target, sum + ints[i], newPath, i);
        }
    }
}
