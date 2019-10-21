package fb;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/merge-intervals/solution/
class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    if(intervals.length <= 1) return intervals;

    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

    int[][] result = new int[intervals.length][];
    int resultPos = 0;

    int min = intervals[0][0];
    int max = intervals[0][1];

    for(int i=1; i<intervals.length; i++) {
      if(intervals[i][0] <= max) {
        max = Math.max(intervals[i][1], max);
      } else {
        result[resultPos] = new int[2];
        result[resultPos][0] = min;
        result[resultPos][1] = max;
        resultPos ++;
        min = intervals[i][0];
        max = intervals[i][1];
      }
    }
    result[resultPos] = new int[2];
    result[resultPos][0] = min;
    result[resultPos][1] = max;
    resultPos ++;

    int[][] compacted = new int[resultPos][];
    for(int i=0;i<resultPos; i++) {
      compacted[i] = new int[2];
      compacted[i][0] = result[i][0];
      compacted[i][1] = result[i][1];
    }

    return compacted;
  }
}
