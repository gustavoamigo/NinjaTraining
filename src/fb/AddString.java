package fb;

// https://leetcode.com/problems/add-strings
class AddString {
  class Solution {
    public String addStrings(String num1, String num2) {
      String rnum1 = reverse(num1);
      String rnum2 = reverse(num2);

      int maxLength = Math.max(rnum1.length(), rnum2.length());
      int remaining = 0;

      StringBuffer result = new StringBuffer();

      for(int i=0; i < maxLength; i++) {
        int a = intOrZero(rnum1, i);
        int b = intOrZero(rnum2, i);
        int sum = a + b + remaining;
        if(sum < 10) {
          result.append(sum);
          remaining = 0;
        } else {
          int r = sum % 10;
          result.append(r);
          remaining = (sum) / 10;
        }
      }

      if(remaining>0) {
        result.append(remaining);
      }


      return result.reverse().toString();
    }


    public int intOrZero(String str, int pos) {
      if(pos<str.length()) {
        return str.charAt(pos) - 48;
      } else {
        return 0;
      }
    }

    public String reverse(String str) {
      return new StringBuffer(str).reverse().toString();
    }
  }
}
