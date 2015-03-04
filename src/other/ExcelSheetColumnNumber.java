package other;
import java.io.IOException;

/**
 * https://oj.leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelSheetColumnNumber {

	private static int pow (int a, int b) {
		if (b == 0) return 1;
		int r = a;
		for(int i=1;i<b;i++) r *= a;
		return r;
	}
	public static int titleToNumber(String s) {
		if(s == null || s.isEmpty()) return 0;
		int r = 0;
		
		for(int i=s.length()-1;i>=0;i--) {
			int c = i == s.length()-1 ? s.charAt(i) - 65 :  pow(26,s.length() - i - 1) * (s.charAt(i) - 65 + 1) ; 
			r += c;
		}
		return r + 1;
    }
	public static void main(String[] args) throws IOException {
		System.out.println(titleToNumber("A"));
		System.out.println(titleToNumber("Z"));
		System.out.println(titleToNumber("AA"));		
		System.out.println(titleToNumber("AB"));
		System.out.println(titleToNumber("BA"));
		System.out.println(titleToNumber("BP"));
		System.out.println(titleToNumber("AAA"));
		System.out.println(titleToNumber("ABW"));
		System.in.read();
	}

}
