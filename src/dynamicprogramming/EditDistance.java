package dynamicprogramming;
/*
 * https://oj.leetcode.com/problems/edit-distance/
 */
public class EditDistance {
	
    public int minDistance(String a, String b) {
        
        if((a == null || a.isEmpty()) && (b == null || b.isEmpty())) return 0;
        if(a == null || a.isEmpty()) return b.length();
        if(b == null || b.isEmpty()) return a.length();

        int[][] e = new int[a.length()+1][b.length()+1];
		
		for(int i = 0; i<= a.length(); i++) e[i][0] = i;
		for(int j = 0; j<= b.length(); j++) e[0][j] = j;
		e[0][0] = 0;
		
		for(int i = 1; i <= a.length(); i++) {
			for(int j  = 1; j <= b.length(); j ++) {
				int x = 1 + e[i-1][j];
				int y = 1 + e[i][j-1];
				
				
				int z = 1;				
				if(a.charAt(i - 1) == b.charAt(j - 1)) z = 0;
				z = z +  e[i-1][j-1];

				if(x <= y && x <= z ) {
					e[i][j] = x;
				} else if(y <= x && y <= z ) {
					e[i][j] = y;
				} else {
					e[i][j] = z;
				}
			}
		}
		
		return e[a.length()][b.length()];
    }
	
	public int minDistanceRecursive(String a, String b, int i, int j) {
		if(i == 0 && j == 0) return 0;
		if(j == 0) return i;
		if(i == 0) return j;

		int x = 1 + minDistanceRecursive(a, b, i-1, j);
		int y = 1 + minDistanceRecursive(a,b, i, j-1);
		
		int z = 1;
		
		if(a.charAt(i - 1) == b.charAt(j - 1)) z = 0;
		
		z = z + minDistanceRecursive(a, b, i-1, j-1 );
		
		if(x <= y && x <= z ) return x;
		if(y <= x && y <= z ) return y;
		
		return z;
	}
	public int minDistanceRecursive(String a, String b) {
		return minDistanceRecursive(a, b, a.length()-1, b.length()-1);
	}

	public static void main(String[] args) {
		EditDistance edit = new EditDistance();
		System.out.println(edit.minDistanceRecursive("EXPONENTIAL", "POLYNOMIAL"));
		System.out.println(edit.minDistance("EXPONENTIAL", "POLYNOMIAL"));
		System.out.println(edit.minDistance("a", "b"));

	}

}
