package fb;

import java.util.*;

public class VerticalOrderTraversalBinaryTree {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    int minX = 0;
    int maxX = 0;
    int minY = 0;
    int maxY = 0;


    private void visit(TreeNode node, int x, int y, HashMap<List<Integer>, List<Integer>> solution) {
        if(node == null) return;
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
        List<Integer> coord = Arrays.asList(x,y);
        if(!solution.containsKey(coord)) {
            solution.put(coord, new ArrayList<>());
        }
        solution.get(coord).add(node.val);
        visit(node.left, x - 1, y + 1, solution);
        visit(node.right, x + 1, y + 1, solution);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        minX = 0;
        maxX = 0;
        minY = 0;
        minY = 0;
        HashMap<List<Integer>, List<Integer>> solution = new HashMap<>();
        visit(root, 0, 0, solution);
        List<List<Integer>> result = new ArrayList<>();
        for(int x = minX; x <= maxX; x++) {
            List<Integer> rows = new ArrayList<>();
            for(int y = minY; y<= maxY; y++) {
                List<Integer> coord = Arrays.asList(x,y);
                if(solution.containsKey(coord)) {
                    Collections.sort(solution.get(coord));
                    rows.addAll(solution.get(coord));
                }
            }
            result.add(rows);
        }
        return result;
    }
}
