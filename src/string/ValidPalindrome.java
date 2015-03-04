package string;
/*
 * http://oj.leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    private boolean isAlphanumeric(char c) {
        if( ( c >= 48 && c <= 57 ) || ( c >= 65 && c<= 90 ) || ( c >= 97 && c <= 122 ) ) return true;
        return false;
    }
    
    private boolean isEqualIgnoreCase(char a, char b) {
        if( a == b || ( (a - b) == 32 ) || ( (b - a) == 32 ) ) return true;
        return false;
    }
    
    public boolean isPalindrome(String s) {
        if( s.isEmpty() ) return true;
        int l = 0;
        int r = s.length() - 1;
        boolean isPalindrome = false;
        boolean onlySpace = true;
        while( l<=r ) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if( !isAlphanumeric(lc) ) {
                l++;
            } else if( !isAlphanumeric(rc) ) {
                r--;
            } else {
                onlySpace = false;
                if( isEqualIgnoreCase(lc,rc) )  {
                    // At least one has to match
                    isPalindrome = true;
                    l++;
                    r--;
                } else {
                    return false;
                }
            }
        }
        return isPalindrome || onlySpace;
    }
    
    public static void main(String[] args) {
    	ValidPalindrome solution = new ValidPalindrome();
    	System.out.println(solution.isPalindrome("Not a enot"));
    	System.out.println(solution.isPalindrome("Not a ton"));
    	System.out.println(solution.isPalindrome("Not aab; ton"));
    	System.out.println(solution.isPalindrome("Not ; ton"));

	}
}
