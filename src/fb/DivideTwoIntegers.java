package fb;

// https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/308/
class DivideTwoIntegers {
  public int divide(int dividend, int divisor) {
    if (dividend == 0) { return 0; }

    final int result;
    if (abs(divisor) == 1) {
      result = abs(dividend);
    } else {
      result = search(abs(dividend), abs(divisor), 0, abs(dividend));
    }

    if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
      return inv(result);
    } else {
      return result;
    }
  }

  private int abs(int i) {
    if (i >= 0) {
      return i;
    } else {
      return inv(i);
    }
  }

  private int inv(int i) {
    return 0 - i;
  }

  // dividend = 1 divisor = 2
  private int search(int dividend, int divisor, int low, int high) { // low = 1 high = 2
    if (dividend < divisor) { return 0; }
    if (low == high) { return low; }
    int diff = high - low; // diff = 1
    int candidate = low + (diff >> 1); // candidate = 1 + 0 = 1
    int sum = 0;
    int i = 0;
    while (sum < dividend) {  // i = 3 sum = 3
      sum += candidate;
      i++;
    }

    if (sum > dividend) {
      i--; // i = 1
    }

    if (i == divisor || i == (divisor + 1)) { // false
      return candidate;
    } else if (i > divisor) { // // i = 1 divisor = 2
      return search(dividend, divisor, candidate, high);
    } else {
      return search(dividend, divisor, low, candidate);
    }
  }

  public static void main(String[] args) {
    DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
    System.out.println(divideTwoIntegers.divide(20, 5));
  }
}
