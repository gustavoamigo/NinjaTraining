package fb;

import java.util.Arrays;

class KClosest {

  public int[][] kClosest(int[][] points, int K) {
    Arrays.sort(points, (p1, p2) -> compare(dist(p1[0],p1[1]), dist(p2[0], p2[1])));
    int min = Math.min(K, points.length);
    int[][] result = new int[min][];
    for(int i=0;i<min;i++) {
      result[i] = points[i];
    }
    return result;
  }

  private int compare(double x, double y) {
    return x == y ? 0 : x < y ? -1 : 1;
  }

  private double dist(int x, int y) {
    return Math.sqrt(x*x + y*y);
  }
}
