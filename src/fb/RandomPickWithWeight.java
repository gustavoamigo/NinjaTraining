package fb;

import java.util.Random;

public class RandomPickWithWeight {
    int sum = 0;
    int[] p = new int[1];
    Random random = new Random();

    public RandomPickWithWeight(int[] w) {
        p = new int[w.length];
        for(int i = 0; i < w.length ; i++) {
            sum+= w[i];
            p[i] = sum;
        }
    }

    public int pickIndex() {
        int target = random.nextInt(sum);

        for(int i=0 ; i<p.length; i++) {
            if(p[i] > target) return i;
        }

        return p.length - 1;
    }
}
