package fb;

// https://leetcode.com/problems/first-bad-version/
class BadVersion {

  int firstBadVersion;

  public BadVersion(int firstBadVersion) {
    this.firstBadVersion = firstBadVersion;
  }

  private boolean isBadVersion(int version) {
    return version>=firstBadVersion;
  }

  public int firstBadVersion(int n) {
    int min=0;
    int max=n;

    while(min!=max) {

      int mid = (max - min) / 2 + min;
      if(isBadVersion(mid)) {
        max=mid;
      } else {
        min=mid+1;
      }
    }
    return min;
  }


  public static void main(String[] args) {

    System.out.println(new BadVersion(1702766719).firstBadVersion(2126753390));
  }

}
