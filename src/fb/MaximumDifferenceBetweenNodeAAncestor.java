package fb;

import java.util.ArrayList;
import java.util.List;

public class MaximumDifferenceBetweenNodeAAncestor {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int max = Integer.MIN_VALUE;

    private void visit(TreeNode node, List<Integer> ancestors) {
        if (node == null) return;

        if (!ancestors.isEmpty()) {
            for (Integer val : ancestors) {
                max = Math.max(max, Math.abs(val - node.val));
            }
        }

        List<Integer> newList = new ArrayList<>(ancestors);
        newList.add(node.val);

        visit(node.left, newList);
        visit(node.right, newList);
    }

    public int maxAncestorDiff(TreeNode root) {

        max = Integer.MIN_VALUE;
        visit(root, new ArrayList<>());
        return max;
    }
}
