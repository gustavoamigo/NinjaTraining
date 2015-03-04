package binarytree;

import java.util.ArrayList;
import java.util.Stack;
/*
 * https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        
        ArrayList<Integer> traversal = new ArrayList<Integer>();
        
        if(root == null) return traversal;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(stack.size()!=0) {
            TreeNode node = stack.pop();
            traversal.add(node.val);
            if(node.right!=null) {
                stack.push(node.right);
            }
            if(node.left!=null) {
                stack.push(node.left);
            }
            
        }
        return traversal;
    }
}
