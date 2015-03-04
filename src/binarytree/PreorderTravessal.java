package binarytree;

public class PreorderTravessal {
	
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    static int i = 0;
    private TreeNode buildTree(int[] preorder, int[] inorder, int l, int r) {
        
        if( i >= preorder.length 
            || l < 0 
            || r < 0 
            || l > r 
            || l >= preorder.length 
            || r >= preorder.length ) { 
                return null;
            }
        
        TreeNode node = new TreeNode(preorder[i]);
        
        if( l == r ) {
            i++;
            return node;
        }
        
        int j;
        for( j = l; j <= r ; j++ ) {
           if(preorder[i] == inorder[j]) break; 
        }
        
        i++;
        
        node.left = buildTree(preorder, inorder, l, j-1);
        node.right = buildTree(preorder, inorder, j+1,  r);
        
        return node;
    }
    
    public TreeNode buildTree( int[] preorder, int[] inorder ) {
        i = 0;
        return buildTree( preorder, inorder, 0, preorder.length - 1 );
        
    }

	public static void main(String[] args) {
		PreorderTravessal tree = new PreorderTravessal();
		int[] preorder = {1,2};
		int[] inorder = {1,2};
		tree.buildTree(preorder, inorder);

	}

}
