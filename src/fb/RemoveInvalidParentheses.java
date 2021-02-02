package fb;

import java.util.*;

public class RemoveInvalidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '(' ) stack.add(c);
            if(c == ')' ) {
                if(stack.empty()) return false;
                stack.pop();
            }
        }
        return stack.size() == 0;
    }

    private String removeAt(String s, int i) {
        return s.substring(0, i) + s.substring(i + 1);
    }

    private void recursive(String s, int leftMisplaced, int rightMisplaced, List<String> solutions, Set<String> visited) {

        // avoid doing the same solution again
        if(visited.contains(s)) return;
        visited.add(s);

        // if all misplaced left and right parenthesis have been removed, check if current string is a solution
        if(leftMisplaced == 0 && rightMisplaced == 0) {
            if(isValid(s)) solutions.add(s);
            return;
        }

        for(int i = 0; i < s.length() ; i++) {
            if(leftMisplaced > 0 && s.charAt(i) == '(') {
                String candidate = removeAt(s, i);
                recursive(candidate, leftMisplaced - 1, rightMisplaced, solutions, visited);
            }
            if(rightMisplaced > 0 && s.charAt(i) == ')') {
                String candidate = removeAt(s, i);
                recursive(candidate, leftMisplaced, rightMisplaced - 1, solutions, visited);
            }
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        // edge case - s is already valid
        if(isValid(s)) {
            return Arrays.asList(s);
        }

        // count number of left and right misplaced parenthesis
        int leftMisplaced = 0;
        int rightMisplaced = 0;
        int balance = 0;
        for(char c: s.toCharArray()) {
            if(c == '(') {
                balance++;
            } else if(c == ')') {
                if(balance == 0) {
                    rightMisplaced++;
                } else {
                    balance --;
                }
            }
        }
        leftMisplaced += balance;

        List<String> solutions = new ArrayList<>();
        // solve problem recursively
        recursive(s, leftMisplaced, rightMisplaced, solutions, new HashSet<>());
        if(solutions.size() == 0) return Arrays.asList("");
        return solutions;
    }
}
