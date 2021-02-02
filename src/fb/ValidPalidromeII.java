package fb;

import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/289/
 */
public class ValidPalidromeII {
    private boolean validPalindrome(String s, int edits) {
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return edits == 00 && (validPalindrome(s.substring(i+1 , s.length() - i), 1)
                        || validPalindrome(s.substring(i, s.length() - i - 1), 1));
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {

        return validPalindrome(s, 0);
    }
}
