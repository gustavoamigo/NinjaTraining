package fb;

import java.util.Stack;


class BSTIterator {
  static public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) { val = x; this.left = left; this.right = right; }
  }







  static public void visit(TreeNode root) {
    System.out.print(root.val + " ");
  }

  public static void visitInOrderStack(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;
    while(true) {
      if(current != null) {
        stack.push(current);
        current = current.left;
      } else {
        if(stack.size() == 0) break;
        TreeNode node = stack.pop();
        visit(node);
        current = node.right;
      }
    }
  }




  Stack<TreeNode> stack = new Stack<>();
  TreeNode current;

  public BSTIterator(TreeNode root) {
    current = root;
  }

  /** @return the next smallest number */
  public int next() {
    int next;
    while(true) {
      if(current != null) {
        stack.push(current);
        current = current.left;
      } else {
        if(stack.size() == 0) throw new RuntimeException();
        TreeNode node = stack.pop();
        next = node.val;
        current = node.right;
        break;
      }
    }
    return next;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return stack.size() != 0 || current != null;
  }

  static public TreeNode node(int x, TreeNode left, TreeNode right) {
    return new TreeNode(x, left, right);
  }


  public static void main(String[] args) {
    TreeNode root = node(4, node(3, node(2, node(1, null, null), null), null), node(5, null, node(6, null, null)));
    //visitInOrderStack(root);

    BSTIterator bstIterator = new BSTIterator(root);
    while (bstIterator.hasNext()) System.out.println(bstIterator.next());
  }
}
