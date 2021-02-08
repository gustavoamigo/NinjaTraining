package fb;

import java.util.HashMap;
import java.util.Stack;

/*
https://leetcode.com/problems/basic-calculator-ii/submissions/
 */
public class CalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuffer buf = new StringBuffer();
        char op = ' ';
        int i = 0;
        for(char c: s.toCharArray()) {
            if(c>='0' && c<='9') {
                buf.append(c);
            }
            if(c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                stack.add(Integer.parseInt(buf.toString()));
                if(op == '-') {
                    int num = stack.pop();
                    stack.add(num * -1);
                } else if( op == '*') {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.add(num1*num2);
                } else if( op == '/') {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.add(num2/num1);
                }
                buf = new StringBuffer();
                op = c;
            }
            i++;
        }
        int result = 0;
        while(!stack.isEmpty()) result+=stack.pop();
        return result;
    }
}
