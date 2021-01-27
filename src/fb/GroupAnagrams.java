package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3014/
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<ArrayList<Integer>, List<String>> group = new HashMap<>();
        for(String str: strs) {
            List<String> list = group.get(key(str));
            if(list == null) list = new ArrayList<String>();
            list.add(str);
            group.put(key(str), list);
        }
        List<List<String>> result = new ArrayList<>();
        result.addAll(group.values());
        return result;
    }

    private ArrayList<Integer> key(String str) {
        int size = 'z' - 'a' + 1;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < size; i++) arr.add(0);
        for(int i = 0; i < str.length(); i++) arr.set(str.charAt(i) - 'a', arr.get(str.charAt(i) - 'a') + 1);
        return arr;
    }
}
