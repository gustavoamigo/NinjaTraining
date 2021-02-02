package fb;

import java.util.Stack;

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
        ValidParenthesis solution = new ValidParenthesis();
        System.out.println(solution.isValid("()"));
    }
}
