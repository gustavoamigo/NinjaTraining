package fb;

/*
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        String result = s;
        // forward
        int o = 0;
        int c = 0;
        int i = 0;
        while(i< result.length()) {
            if(result.charAt(i) == '(') o++;
            if(result.charAt(i) == ')') c++;
            if(o - c < 0) {
                result =  removeAt(result, i);
                c--;
            } else {
                i ++;
            }
        }
        // backward
        o = 0;
        c = 0;
        i = result.length() - 1;
        while(i >= 0) {
            if(result.charAt(i) == '(') o++;
            if(result.charAt(i) == ')') c++;
            if(c - o < 0) {
                result =  removeAt(result, i);
                o--;
            }
            i --;
        }
        return result;
    }

    private String removeAt(String s, int pos) {
        return s.substring(0, pos) + safeSubstring(s, pos + 1);
    }

    private String safeSubstring(String value, int beginIndex) {
        int subLen = value.length() - beginIndex;
        if (subLen < 0) {
            return "";
        }
        return value.substring(beginIndex);
    }

    public static void main(String[] args) {
        MinimumRemovetoMakeValidParentheses c = new MinimumRemovetoMakeValidParentheses();
        System.out.printf("'%s'\n",c.minRemoveToMakeValid("(()"));
        System.out.printf("'%s'\n",c.minRemoveToMakeValid("())")); // OK
        System.out.printf("'%s'\n",c.minRemoveToMakeValid("a(b)a)d")); // OK
        System.out.printf("'%s'\n",c.minRemoveToMakeValid("(a(b)ad")); // OK
         System.out.printf("'%s'\n",c.minRemoveToMakeValid("(")); // OK
         System.out.printf("'%s'\n",c.minRemoveToMakeValid(")")); // OK
         System.out.printf("'%s'\n",c.minRemoveToMakeValid("a)b")); // OK
         System.out.printf("'%s'\n",c.minRemoveToMakeValid(")(")); // OK
         System.out.printf("'%s'\n",c.minRemoveToMakeValid("))((")); // NOK
         System.out.printf("'%s'\n",c.minRemoveToMakeValid(")(())))")); // NOK
    }
}
