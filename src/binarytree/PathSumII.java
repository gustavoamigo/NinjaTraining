package binarytree;
import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/path-sum-ii/
 */

public class PathSumII {
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	final List<List<Integer>> result = new LinkedList<>();
    	if(root == null) return result;
    	pathSumRecursively(root, sum, 0, new LinkedList<Integer>(), new Accept() {
			@Override
			public void accept(List<Integer> route) {
				result.add(route);
			}
		});
    	return result;
    }
    
	
	interface Accept {
		void accept(List<Integer> route);
	}

    
    private void pathSumRecursively(TreeNode root, int sum, int current, List<Integer> route, Accept callback) {
    	
    	current += root.val;
    	route.add(root.val);
    	if(current == sum && root.left == null && root.right == null) {
    		callback.accept(route);
    		return;
    	}
    	if(root.left != null) pathSumRecursively(root.left, sum, current, new LinkedList<Integer>(route), callback);
    	if(root.right != null) pathSumRecursively(root.right, sum, current, new LinkedList<Integer>(route), callback);
    }	
}
