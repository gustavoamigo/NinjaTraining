package fb;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/280/
class BinaryTreePaths {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
  }

  List<String> solutions = new LinkedList<>();

  public List<String> binaryTreePaths(TreeNode root) {
    visit(root, "");
    return solutions;
  }

  private void visit(TreeNode root, String path) {
    if (root == null) { return; }

    final String newPath;

    if (path.length() == 0) {
      newPath = "" + root.val;
    } else {
      newPath = path + "->" + root.val;
    }

    if (root.left == null && root.right == null) {
      solutions.add(newPath);
      return;
    }

    visit(root.left, newPath);
    visit(root.right, newPath);
  }
}
