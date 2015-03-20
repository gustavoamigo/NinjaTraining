package number;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class NumberOfBinarySearchTree {
	
	public int numTrees(int n) {
		long i = n;
        switch (n) {
		case 0:
			return 1;
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 5;

		default:
			long a = ((long)numTrees(n-1)) * (4*i-2);
			long b = a/(i+1);
			return (int)b;
		}
    }
	
	public static void main(String[] args) {
		NumberOfBinarySearchTree solution = new NumberOfBinarySearchTree();
		for(int i=0;i<20;i++) {
			System.out.println(solution.numTrees(i));
		}
	}

}
