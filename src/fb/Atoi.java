package fb;

public class Atoi {
    public int myAtoi(String s) {
        int result = 0;
        int signal = 1;
        int i = 0;
        boolean isReading = false;
        while(i<s.length()) {
            if(!isReading) {
                if(s.charAt(i) == ' ') {
                    // just skip
                } else if(s.charAt(i) == '-') {
                    isReading = true;
                    signal = -1;
                } else if(s.charAt(i) == '+') {
                    isReading = true;
                    signal = 1;
                } else if(isDigit(s.charAt(i))) {
                    isReading = true;
                    result = (int) s.charAt(i) -  '0';
                } else {
                    return 0;
                }
            } else {
                if(isDigit(s.charAt(i))) {
                    if(signal == 1) {
                        if( (result * 10L + (long) s.charAt(i) -  '0') >=  Integer.MAX_VALUE) {
                            return Integer.MAX_VALUE;
                        }
                    } else {
                        if(((result * 10L + (long) s.charAt(i) -  '0') * signal) <=  Integer.MIN_VALUE) {
                            return Integer.MIN_VALUE;
                        }
                    }
                    result = result * 10 + (int) s.charAt(i) -  '0';
                } else {
                    break;
                }
            }
            i++;

        }
        return result * signal;
    }


    private boolean isDigit(char c) {
        if(c == '0' ||
                c == '1' ||
                c == '2' ||
                c == '3' ||
                c == '4' ||
                c == '5' ||
                c == '6' ||
                c == '7' ||
                c == '8' ||
                c == '9'
        ) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Atoi a = new Atoi();
        System.out.println(a.myAtoi("-6147483648"));
    }
}
