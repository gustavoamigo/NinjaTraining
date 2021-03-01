package binarytree;

public class LargestBSTSubtree {

    public class TreeNode {
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

    int maxCount = 0;

    private int isBST(TreeNode node, int min, int max) {
        if(node == null) return 0;

        maxCount = Math.max(maxCount, 1);

        int left = 0;
        int right = 0;

        boolean isBst = node.val > min && node.val < max;

        if(node.left!=null) {
            left = isBST(node.left, isBst ? min : Integer.MIN_VALUE, node.val);
        }

        if(node.right!=null) {
            right = isBST(node.right, node.val, isBst ? max : Integer.MAX_VALUE);
        }

        if(left != -1 && right != -1) {
            int count = left + right + 1;
            maxCount = Math.max(maxCount, count);
            return isBst ? count : -1;
        } else {
            return -1;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        maxCount = 0;
        isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return maxCount;
    }
}
