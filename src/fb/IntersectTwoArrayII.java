package fb;

import java.util.ArrayList;
import java.util.HashMap;

/*
https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/270/
 */
public class IntersectTwoArrayII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            freq.put(nums1[i], freq.getOrDefault(nums1[i], 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++) {
            if(freq.containsKey(nums2[i])) {
                int f = freq.get(nums2[i]);
                freq.put(nums2[i], freq.get(nums2[i]) - 1);
                if(f >= 1) result.add(nums2[i]);
            }
        }
        int[] resultArray = new int[result.size()];
        for(int i = 0; i< resultArray.length; i++) resultArray[i] = result.get(i);
        return resultArray;
    }
}
