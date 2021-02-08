package fb;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/*
https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/3024/
 */
public class LowestCommonAncestorOfABinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int minDepth = Integer.MAX_VALUE;
    TreeNode answer = null;

    private boolean visit(TreeNode node, TreeNode p, TreeNode q, int depth) {
        if (node == null) return true;

        boolean ok = visit(node.left, p, q, depth + 1);
        if (!ok) return ok;

        if (answer != null) {
            if (depth < minDepth) {
                minDepth = depth;
                answer = node;
            }
            if (node == p || node == q) {
                return false;
            }
        } else {
            if (node == p || node == q) {
                minDepth = depth;
                answer = node;
            }
        }

        ok = visit(node.right, p, q, depth + 1);
        return ok;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<String> a = new ArrayList<>();


        minDepth = Integer.MAX_VALUE;
        answer = null;
        visit(root, p, q, 1);
        return answer;
    }
}
