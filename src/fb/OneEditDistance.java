package fb;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length() - t.length()) > 1) return false;

        if(s.length() == t.length()) {
            int edits = 0;
            for(int i = 0 ; i < s.length() ; i++) {
                if(s.charAt(i) != t.charAt(i)) {
                    edits ++;
                }
                if(edits > 1) return false;
            }
            return edits == 1 ? true : false;
        }

        if(s.length() < t.length()) return isOneEditDistance(t, s); // so s is alwways larger
        if(t.length() == 0) return true;

        int edits = 0;
        for(int i = 0; i<s.length(); i++) {
            if(i - edits >= t.length() || s.charAt(i) != t.charAt(i - edits)) {
                edits++;
            }
            if(edits > 1) return false;
        }

        return edits == 1 ? true : false;
    }
}
