package fb;

import java.util.Arrays;
import java.util.Comparator;

class KClosest {

  public int[][] kClosest(int[][] points, int K) {
    Arrays.sort(points, Comparator.comparingDouble(p -> dist(p[0], p[1])));
    int min = Math.min(K, points.length);
    int[][] result = new int[min][];
    for(int i=0;i<min;i++) {
      result[i] = points[i];
    }
    return result;
  }

  private double dist(int x, int y) {
    return Math.sqrt(x*x + y*y);
  }
}
