package fb;

class IsPalindrome {
  public boolean isPalindrome(String s) {
    String str = removeNonAlphanumeric(s);
    int half = str.length() / 2;

    for(int i = 0; i< half; i++ ) {
      if(!isEqual(str.charAt(i),str.charAt(str.length() - i - 1))) return false;
    }
    return true;
  }

  private boolean isEqual(Character a, Character b) {
    if(isAlphanumeric(a) && isAlphanumeric(a)) {
      return toLower(a) == toLower(b);
    } else {
      if(isAlphanumeric(a) || isAlphanumeric(a)) return false;
      else return true;
    }
  }

  private String removeNonAlphanumeric(String s) {
    StringBuffer result = new StringBuffer();
    for(int i = 0; i<s.length(); i++) {
      if(isAlphanumeric(s.charAt(i))) result.append(s.charAt(i));
    }
    return result.toString();
  }

  private boolean isAlphanumeric(Character a) {
    if(a >= 'a' && a <= 'z' || a >= 'A' && a <= 'Z' ||  a >= '0' && a <= '9' ) return true;
    else return false;
  }

  private Character toLower(Character a) {
    if(a >= 'A' && a <= 'Z') {
      int z = a - 'A' + 'a';
      return (char) z;
    } else return a;
  }

}
