package fb;

// https://leetcode.com/problems/diameter-of-binary-tree/
class DiameterBinaryTree {
   static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

     TreeNode(int x) {
       val = x;
     }
   }
  /**
   * Definition for a binary tree node.


   x
   x
   x
   x   x
   x x
   x

   x
   x   x
   x    x
   x   x    x
   x x
   x

   5
   4   2
   3    1
   0   2   0
   1 1
   0

   8
   4   2
   3    1
   0   2   0
   1 1
   0


   x
   x   x
   x x

   2
   1   1
   0 0



   * }
   */

    public int diameterOfBinaryTree(TreeNode root) {
      return 0;
    }

    private int depth(TreeNode node) {
      if(node == null)
        return 0;
      else {
      int l = depth(node.left);
      int r = depth(node.right);
      node.val = Math.max(l, r);
      return node.val + 1;
    }
  }

  private int maxPath(TreeNode node) {
    if(node == null) {
      return 0;
    } else if(node.left != null && node.right == null) {

    } else if(node.left == null && node.right != null) {

    } else if(node.left != null && node.right != null) {
      int l = node.left.val;
      int r = node.right.val;
      int path = l + r + 1;
    }

    return 0;
  }


}
