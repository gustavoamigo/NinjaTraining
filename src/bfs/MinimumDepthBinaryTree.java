package bfs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return bfs(root, 1);
    }

    private int bfs(TreeNode node, int depth) {

        for(int i =0, j=0;i<2&&j<2;) {

            i++;
            j++;
        }

        if(isLeaf(node)) return depth;
        List<List<Integer>> ans = new ArrayList<>();

        int leftDepth = Integer.MAX_VALUE;
        if(node.left != null) leftDepth = bfs(node.left, depth + 1);
        int rightDepth = Integer.MAX_VALUE;
        if(node.right != null) rightDepth = bfs(node.right, depth + 1);
        return Math.min(leftDepth, rightDepth);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

