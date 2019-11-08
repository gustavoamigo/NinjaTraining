package fb;

// https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/308/
class DivideTwoIntegers {

  public int divide(int dividend, int divisor) {
    int sign = (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) ? -1 : 1;

    long q = 0;
    long dividendL = Math.abs((long) dividend);
    long divisorL = Math.abs((long) divisor);
    if (divisorL == 1) {
      q = dividendL;
    } else {
      while (dividendL >= divisorL) {
        dividendL -= divisorL;
        q++;
      }
    }


    if (q > Integer.MAX_VALUE) {
      return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    } else {
      return (int) q * sign;
    }

  }

  public static void main(String[] args) {
    DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
    System.out.println(divideTwoIntegers.divide(20, 6));
  }
}
