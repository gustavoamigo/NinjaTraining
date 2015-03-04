package string;
/*
 * https://oj.leetcode.com/problems/longest-common-prefix/
 */
public class LCP {
	
	static public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";
		String prefix = strs[0];
		for(int i = 1; i<strs.length; i++) {
			String s = strs[i];
			int j = 0;
			for(; j < s.length() && j < prefix.length(); j++) {
				if(s.charAt(j) != prefix.charAt(j))
					break;
			}
			prefix = prefix.substring(0, j);
		}
		return prefix;
	}
	
	
	public static void main(String[] args) {
		String[] strs = { "", "b"};
		System.out.println(longestCommonPrefix(strs));
		
	}
	
}
