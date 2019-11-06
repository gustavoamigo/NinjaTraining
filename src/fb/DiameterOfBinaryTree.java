package fb;

// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/291/
class DiameterOfBinaryTree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
  }

  int diameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    visit(root);
    return diameter;
  }

  private int visit(TreeNode root) {
    if (root == null) { return 0; }

    int left = visit(root.left);
    int right = visit(root.right);

    int localDiameter = left + right;
    diameter = Math.max(diameter, localDiameter);

    return Math.max(left, right) + 1;
  }

  public static void main(String[] args) {
    System.out.println(-10 >> 1);
  }
}
