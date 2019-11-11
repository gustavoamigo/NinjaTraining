package fb;
// https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/3031/
class Pow {
  public double myPow(double x, int n) {
    if(n == Integer.MIN_VALUE) return 1 / ( myPow(x, Integer.MAX_VALUE) * x);
    if(n>=0) {
      if(n == 1) return x;
      if(n == 0) return 1;
      int half = n >> 1;
      double pow = myPow(x, half);
      if(n % 2 == 0) {
        return pow * pow;
      } else {
        return pow * pow * x;
      }
    } else {
      return 1/myPow(x, Math.abs(n));
    }
  }
}
