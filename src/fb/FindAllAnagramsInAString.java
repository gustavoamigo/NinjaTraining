package fb;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    private boolean equals(int[] a, int[] b) {
        if(a.length != b.length) return false;
        for(int i=0;i<a.length;i++) {
            if(a[i] != b[i]) return false;
        }
        return true;
    }


    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) return new ArrayList<>();
        int[] pf = new int[26];

        // create a frequency table
        for(char c: p.toCharArray()) {
            int ci = c - 'a';
            pf[ci] = pf[ci] + 1;
        }

        int window = p.length();

        int[] sf = new int[26];

        // fill out window
        for(int i=0; i<window; i++) {
            int ci = s.charAt(i) - 'a';
            sf[ci] = sf[ci] + 1;
        }

        // check if it's a solution
        List<Integer> solutions = new ArrayList<>();
        if(equals(pf, sf)) solutions.add(0);

        // slide window to the right until the end, check if it's a solution in every step
        int l = 0;
        int r = window;
        for(int i = 0; i < s.length() - window; i++) {
            char cl = s.charAt(i);
            sf[cl - 'a'] = sf[cl - 'a'] - 1;

            char cr = s.charAt(i + window);
            sf[cr - 'a'] = sf[cr - 'a'] + 1;
            if(equals(pf, sf)) solutions.add(i + 1);
        }
        return solutions;
    }
}
