package fb;
// https://leetcode.com/explore/interview/card/facebook/55/dynamic-programming-3/3034/
class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    int[] solution = {0, 0};
    for(int i=0;i<s.length();i++) {
      solution =  maxString(findPolindrome(s, i, i), solution);
      solution =  maxString(findPolindrome(s, i, i+1), solution);
    }
    return s.substring(solution[0], solution[1]);
  }

  private int[] maxString(int[] a, int[] b) {
    if(a[1] - a[0] > b[1] - b[0]) {
      return a;
    } else {
      return b;
    }
  }

  private int[] findPolindrome(String s, int start, int end) {
    while(true) {
      if(start < 0 || end >= s.length()) {
        return new int[]{start + 1, end};
      } else {
        if(s.charAt(start) == s.charAt(end)) {
          start --;
          end ++;
        } else {
          return new int[]{start + 1, end};
        }
      }
    }
  }

  public static void main(String[] args) {
    LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
    System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
  }
}
