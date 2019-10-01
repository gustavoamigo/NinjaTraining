package fb;

// https://leetcode.com/problems/add-binary/
class AddBinarySmallInt {
  public String addBinary(String a, String b) {
    return toBinary(fromBinary(a) + fromBinary(b));
  }


  public int fromBinary(String binary) {
    char[] binaryChars = binary.toCharArray();
    int resultInt = 0;
    for (int i = 0; i < binaryChars.length; i++) {
      if (binaryChars[binaryChars.length - i - 1] == '1') {
        resultInt += Math.pow(2, i);
      }
    }

    return resultInt;
  }

  public String toBinary(int i) {
    if (i == 0) { return "0"; }
    StringBuffer result = new StringBuffer();
    int remaining = i;
    while (remaining > 0) {
      boolean isOdd = remaining % 2 == 1;
      if (isOdd) {
        result.append("1");
      } else {
        result.append("0");
      }
      remaining = remaining >> 1;
    }
    return result.reverse().toString();
  }

  public static void main(String[] args) {
    AddBinarySmallInt addBinary = new AddBinarySmallInt();
    System.out.println(addBinary.fromBinary("0"));
    System.out.println(addBinary.fromBinary("1"));
    System.out.println(addBinary.fromBinary("10"));
    System.out.println(addBinary.fromBinary("11"));
    System.out.println(addBinary.fromBinary("100"));
    System.out.println(addBinary.fromBinary("101"));
    System.out.println(addBinary.fromBinary("0101"));

    System.out.println(addBinary.toBinary(0));
    System.out.println(addBinary.toBinary(1));
    System.out.println(addBinary.toBinary(2));
    System.out.println(addBinary.toBinary(3));
    System.out.println(addBinary.toBinary(4));
    System.out.println(addBinary.toBinary(5));
  }
}
