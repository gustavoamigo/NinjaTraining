package binarytree;

/* 
 * https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class SortedListToBinarySearchTree {

	//Definition for singly-linked list.
	static public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; next = null; }
	}


	//Definition for binary tree
	static public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public void inOrderPrint(TreeNode root) {
		if(root != null) {
			System.out.print("[");
			inOrderPrint(root.left);
			System.out.print("{");
			System.out.print(root.val);
			System.out.print("}");
			inOrderPrint(root.right);
			System.out.print("]");
		}
	}
	
    public TreeNode sortedListToBST(ListNode head) {
    	if(head == null) return null;
    	if(head.next == null) return new TreeNode(head.val);

    	ListNode previousCurrent = null;
    	ListNode current = head;
    	ListNode tail = head;
    	int i = 0;
    	while(tail != null) {
    		
    		if(i!= 0 && i % 2 == 0) {
    			previousCurrent = current;
    			current = current.next;
    		}
    		i++;
    		tail = tail.next;
    	}
    	
    	
    	TreeNode root = new TreeNode(current.val);
    	
    	if(previousCurrent!=null) {
    		previousCurrent.next = null;
    		root.left = sortedListToBST(head);
    	}
    	
    	if(current.next != null)
    		root.right = sortedListToBST(current.next);
    	
        return root;
    }	
    
	public static void main(String[] args) {
		int[] sorted = {1,2,3,4,5};
		ListNode head = new ListNode(sorted[0]);
		ListNode current = head;
		for (int i = 1; i < sorted.length; i++) {
			ListNode next = new ListNode(sorted[i]);
			current.next = next;
			current = next;
		}
		
		SortedListToBinarySearchTree sol = new SortedListToBinarySearchTree();
		TreeNode root =  sol.sortedListToBST(head);
		sol.inOrderPrint(root);
		

	}

}
