package fb;

// https://leetcode.com/problems/add-binary/
class AddBinaryBigInt {

  public String addBinary(String a, String b) {
    String aR = reverse(a);
    String bR = reverse(b);

    StringBuffer result = new StringBuffer();

    int maxLength = Math.max(a.length(), b.length());
    int remaining = 0;
    for(int i = 0; i<maxLength; i++) {
      int aInt = intAtOrZero(aR, i);
      int bInt = intAtOrZero(bR, i);
      int sum = aInt + bInt + remaining;
      if(sum == 0) {
        result.insert(0, "0");
        remaining = 0;
      } else if(sum == 1) {
        result.insert(0, "1");
        remaining = 0;
      } else if(sum == 2){
        result.insert(0, "0");
        remaining = 1;
      } else {
        result.insert(0, "1");
        remaining = 1;
      }
    }
    if(remaining ==1) {
      result.insert(0, "1");
    }

    return result.toString();
  }



  public int intAtOrZero(String str, int i) {

    if(i>=str.length()) return 0;
    return str.charAt(i) == '1' ? 1 : 0;
  }

  public String reverse(String str) {
    return new StringBuffer(str).reverse().toString();
  }

  public static void main(String[] args) {
    AddBinaryBigInt addBinary = new AddBinaryBigInt();
    System.out.println(addBinary.addBinary("1", "11"));
    System.out.println(addBinary.addBinary("0", "0"));
    System.out.println(addBinary.addBinary("1", "0"));
    System.out.println(addBinary.addBinary("0", "1"));
    System.out.println(addBinary.addBinary("10000", "1"));
    System.out.println(addBinary.addBinary("10001", "1"));

  }
}
