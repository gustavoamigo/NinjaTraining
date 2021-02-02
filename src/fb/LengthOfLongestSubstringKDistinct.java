package fb;

import java.util.HashMap;

/*
 https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3017/
 */
public class LengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> ft = new HashMap<>();
        int l = 0;
        int r = 0;
        int length = 0;
        while(r < s.length()) {
            char rch = s.charAt(r);
            ft.put(rch, ft.getOrDefault(rch, 0) + 1);
            if(ft.size() <= k) {
                int cl = r - l + 1;
                if(cl >= length) length = cl;
            } else {
                ft.size();
                char lch = s.charAt(l);
                ft.put(lch, ft.getOrDefault(lch, 0) - 1);
                if(ft.get(lch) <= 0) ft.remove(s.charAt(l));
                l++;
            }
            r++;
        }
        return length;
    }
}
