package binarytree;

/*
 * https://oj.leetcode.com/problems/path-sum/
 */

public class PathSum {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
    private boolean isLeaf(TreeNode node) {
        if(node.left == null && node.right == null) return true;
        return false;
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if(sum == 0) return false;
        
        sum = sum - root.val;
        
        if(sum == 0 && isLeaf(root)) return true;
        
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        
    }
    
    public static void main(String[] args) {
		
	}
}
