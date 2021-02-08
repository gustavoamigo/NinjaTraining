package fb;

import java.io.Reader;
import java.util.Stack;
import java.util.TreeSet;

public class ValidParenthesis {

    /*

    ()
    (


     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '(' || c== '{' || c == '[') stack.add(c);
            if(c == ')' || c== '}' || c == ']') {
                char pop = stack.pop();
                switch (c) {
                    case ')' : if(pop != '(') return false; break;
                    case '}' : if(pop != '}') return false; break;
                    case ']' : if(pop != ']') return false; break;
                }
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        ValidParenthesis solution = new ValidParenthesis();
        System.out.println(solution.isValid("()"));
    }
}
