package fb;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/3023/
 */
public class BinaryTreeRightSide {
    static class TreeNode {
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

        private void visit(TreeNode node, int depth, ArrayList<Integer> view) {
            if (node == null) return;
            if (depth > view.size()) {
                view.add(node.val);
            }
            if (node.right != null) {
                visit(node.right, depth + 1, view);
            }
            if (node.left != null) {
                visit(node.left, depth + 1, view);
            }
        }

        public List<Integer> rightSideView(TreeNode root) {
            ArrayList<Integer> ans = new ArrayList<>();
            visit(root, 1, ans);
            return ans;
        }
    }
}
