package fb;

import java.util.Stack;

class LongestValidParentheses {
  public int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    int result = 0;
    stack.push(-1);
    for(int i=0; i<s.length(); i ++) {
      if(s.charAt(i) == '(') {
        stack.push(i);
      } else {
        stack.pop();
        if(!stack.isEmpty()) {
          int pos = stack.peek();
          int size = i - pos;
          result = Math.max(result, size);
        } else {
          stack.push(i);
        }
      }
    }
    return result;
  }
}
