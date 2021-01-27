package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringMultiplication {
    public String multiply(String num1, String num2) {
        int[] mult = new int[num1.length() + num2.length()];
        for(int i=num1.length() -1 ; i>=0; i--) {
            int carry=0;
            for(int j=num2.length() - 1;j>=0;j--) {
                int x = num1.charAt(i) - '0';
                int y = num2.charAt(j) - '0';
                mult[i+j+1] += x * y + carry;
                carry = mult[i+j+1] / 10;
                mult[i+j+1] = mult[i+j+1] % 10;
            }
            mult[i] = carry;
        }

        int trailingZero = 0;
        int p = mult[0];
        for(int i = 0; i < mult.length - 1; i++) {
            if(mult[i] == 0 && p == 0) {
                trailingZero++;
            } else {
                p = -1;
            }
        }

        StringBuffer result = new StringBuffer();
        for(int i = trailingZero; i<mult.length; i++) result.append(mult[i]);
        return result.toString();
    }
}
