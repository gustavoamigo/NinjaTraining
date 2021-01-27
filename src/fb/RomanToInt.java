package fb;

public class RomanToInt {
    public int romanToInt(String s) {
        int i = 0;
        int result = 0;
        while(i < s.length()) {
            if(s.charAt(i) == 'I') {
                if(safeCharAt(s, i+1) == 'V') {
                    result += 4;
                    i++;
                } else if(safeCharAt(s, i+1) == 'X') {
                    result += 9;
                    i++;
                } else {
                    result += 1;
                }
            } else if(s.charAt(i) == 'V') {
                result += 5;
            } else if(s.charAt(i) == 'X') {
                if(safeCharAt(s, i+1) == 'L') {
                    result += 40;
                    i++;
                } else if(safeCharAt(s, i+1) == 'C') {
                    result += 90;
                    i++;
                } else {
                    result += 10;
                }
            } else if(s.charAt(i) == 'L') {
                result += 50;
            } else if(s.charAt(i) == 'C') {
                if(safeCharAt(s, i+1) == 'D') {
                    result += 400;
                    i++;
                } else if(safeCharAt(s, i+1) == 'M') {
                    result += 900;
                    i++;
                } else {
                    result += 100;
                }
            } else if(s.charAt(i) == 'D') {
                result += 500;
            } else if(s.charAt(i) == 'M') {
                result += 1000;
            }
            i++;
        }

        return result;
    }

    private char safeCharAt(String s, int pos) {
        if(pos >= s.length()) return ' ';
        return s.charAt(pos);
    }
}
