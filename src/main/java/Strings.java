package main.java;


public class Strings {
    public String reverse(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return reversed;
    }

    public boolean isPalindrome(String input) {
        for (int i = 0, j = input.length() - 1; i != j;) {
            if (!Character.isAlphabetic(input.charAt(i))) {
                i = i + 1;
            } else if (!Character.isAlphabetic(input.charAt(j))) {
                j = j - 1;
            } else if (Character.toLowerCase(input.charAt(i)) == Character.toLowerCase(input.charAt(j))) {
                i = i + 1;
                j = j - 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isCyclicTrajectory(String trajectory) {
        int numberOfRights = this.countOccurrencesOf(trajectory, 'R');
        int numberOfLefts = this.countOccurrencesOf(trajectory, 'L');
        int numberOfTops = this.countOccurrencesOf(trajectory, 'T');
        int numberOfBottoms = this.countOccurrencesOf(trajectory, 'B');
        if(numberOfRights == numberOfLefts && numberOfBottoms == numberOfTops){
            return true;
        }
        return false;
    }

    private int countOccurrencesOf(String s, char c){
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == c){
                count = count + 1;
            }
        };
        return count;
    }
}
