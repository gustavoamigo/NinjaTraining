package fb;

import java.util.HashMap;
import java.util.Set;

class SparseVector {

    HashMap<Integer, Integer> hash = new HashMap<>();

    SparseVector(int[] nums) {
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] != 0) {
                hash.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        Set<Integer> keys = hash.keySet();

        for(Integer pos: keys) {
            if(vec.hash.containsKey(pos)) {
                sum += this.hash.getOrDefault(pos, 0) * vec.hash.getOrDefault(pos, 0);
            }
        }

        return sum;
    }
}
