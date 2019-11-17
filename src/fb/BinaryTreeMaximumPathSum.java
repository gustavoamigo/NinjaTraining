package fb;

class BinaryTreeMaximumPathSum {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
  }

  int maxSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    pathSum(root);
    return maxSum;
  }

  private int pathSum(TreeNode node) {
    if (node == null) { return 0; }
    int left = pathSum(node.left);
    int right = pathSum(node.right);

    // all
    int pathSum = left + right + node.val;
    maxSum = Math.max(pathSum, maxSum);

    // left
    int pathSumLeft = left + node.val;
    maxSum = Math.max(pathSumLeft, maxSum);

    // right
    int pathSumRight = right + node.val;
    maxSum = Math.max(pathSumRight, maxSum);

    // just the node
    maxSum = Math.max(node.val, maxSum);

    return Math.max(node.val, node.val + Math.max(left, right));
  }
}
