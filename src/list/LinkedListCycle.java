package list;

/* 
 * https://oj.leetcode.com/problems/linked-list-cycle/
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
	
	  static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
		
    public boolean hasCycle(ListNode head) {
    	if(head == null) return false;
    	if(head.next == head) return true;
    	if(head.next == null) return false;
    	ListNode stop = head;
    	ListNode current = head;
    	while(current != null) {
    		if(current.next == stop) return true;
    		ListNode previous = current;
    		current = current.next;
    		previous.next = stop;
    	}
        return false;
    }
    
	public static void main(String[] args) {
		LinkedListCycle solution = new LinkedListCycle();
		ListNode head = new ListNode(1);
		head.next = head;
		System.out.println(solution.hasCycle(head));

	}

}
