package fb;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int i = 0;
        int max = 0;
        int z = 0;
        for(int j = 0; j<A.length; j++) {
            if(A[j] == 0) z++;
            if(z<=K) {
                max = Math.max(max, j - i + 1);
            } else {
                while(z>K && i<j) {
                    if(A[i] == 0) z--;
                    i++;
                }
            }
        }
        return max;
    }
}
