package other;
/*
 * https://oj.leetcode.com/problems/jump-game/
 */
public class JumpGame {
    static public boolean canJump(int[] A) {
        int i = 0;
        int maxJump = 1;
        while(i<A.length) {
            maxJump--;
            if(maxJump<A[i]) maxJump = A[i];
            if(maxJump==0) return false;
            i++;
        }
        return true;
    }
	
	public static void main(String[] args) {
		int[] a = {0};
		System.out.println(canJump(a));

	}

}
