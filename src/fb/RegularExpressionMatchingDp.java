package fb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RegularExpressionMatchingDp {

    private boolean isMatch(String s, int si, String p, int pi, HashMap<List<Integer>, Boolean> memo) {
        if(memo.containsKey(Arrays.asList(si, pi))) return memo.get(Arrays.asList(si, pi));
        if(si == s.length() && pi == p.length()) return true;
        if(pi == p.length() && si < s.length()) return false;

        boolean firstMatches = si < s.length()
                && (p.charAt(pi) == '.' || p.charAt(pi) == s.charAt(si));

        if( pi < p.length() - 1 && p.charAt(pi+1) == '*') {
            Boolean ans = firstMatches && isMatch(s, si + 1, p, pi, memo)
                    || isMatch(s, si, p, pi + 2, memo);
            memo.put(Arrays.asList(si, pi), ans);
            return ans;

        } else {
            Boolean ans = firstMatches && isMatch(s, si + 1, p, pi + 1, memo);
            memo.put(Arrays.asList(si, pi), ans);
            return ans;
        }
    }

    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0, new HashMap<>());
    }
    
}
