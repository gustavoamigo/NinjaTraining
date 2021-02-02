package fb;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if(s.isEmpty() && p.isEmpty()) return true;
        if(p.isEmpty() && !s.isEmpty()) return false;
        boolean firstMatches = !(s.isEmpty())
                && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));

        if(p.length()>=2 && p.charAt(1) == '*') {
            return
                    isMatch(s, p.substring(2)) ||
                            firstMatches && isMatch(s.substring(1), p);
        } else {
            return firstMatches && isMatch(s.substring(1), p.substring(1));
        }
    }


}
