package list;

/*
 * https://oj.leetcode.com/problems/sort-list/
 */
public class SortList {
	
	  static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		      public ListNode addNode(int val) {
		    	  ListNode newNode = new ListNode(val);
		    	  this.next = newNode;
		    	  return newNode;
		      }
		      
		      public void print() {
		    	  ListNode head = this;
		    	  System.out.print("[");
		    	  while(head != null) {
		    		  System.out.print(head.val);
		    		  if(head.next != null) System.out.print(",");
		    		  head = head.next;
		    	  }
		    	  System.out.println("]");
		      }
		      
		      @Override
		    public String toString() {
		    return String.valueOf(val);
		    }
	  }
	  
	  public ListNode sortList(ListNode head) {
		  if(head == null) return null;
		  if(head.next == null) return head;
		  
		  ListNode middle = head;
		  ListNode current = head;
		  int i = 0;
		  
		  // Divide in two lists
		  while( current.next != null ) {
			  if( i % 2 == 1) {
				  middle = middle.next;
			  }
			  current = current.next;
			  i++;
		  }
		  
		  ListNode left = head;
		  ListNode right = middle.next;
		  middle.next = null;

		  left = sortList(left);
		  right = sortList(right);
		  
		  return mergeSortedLists(left, right);
	  }
	  
	  public ListNode mergeSortedLists(ListNode left, ListNode right) {
		  ListNode current = null;
		  ListNode head = null;
		  while(left !=null || right !=null) {
			  if(left != null && right != null) {
				  if(left.val <= right.val) {
					  if(current == null) {
						  current = new ListNode(left.val);
						  head = current;
					  } else {
						  current.next = new ListNode(left.val);
						  current = current.next;
					  }
					  left = left.next;
				  } else {
					  if(current == null) {
						  current = new ListNode(right.val);
						  head = current;
					  } else {
						  current.next = new ListNode(right.val);
						  current = current.next;
					  }
					  right = right.next;
				  }
			  } else if(left != null && right == null) {
				  current.next = new ListNode(left.val);
				  current = current.next;
				  left = left.next;
			  } else if(left == null && right != null) {
				  current.next = new ListNode(right.val);
				  current = current.next;
				  right = right.next;
			  }
		  }
		  return head;
	  }
	  
	  public static void main(String[] args) {
		ListNode head = new  ListNode(10);
		head.addNode(2);
		head.print();
		
		SortList sorter = new SortList();
		ListNode sorted = sorter.sortList(head);
		sorted.print();
		
		head = new ListNode(1);
		head.print();
		sorted = sorter.sortList(head);
		sorted.print();
		
		head = new ListNode(3);
		head.addNode(2);
		head.print();
		sorted = sorter.sortList(head);
		sorted.print();
		
		head = new ListNode(2);
		head.addNode(3);
		head.print();
		sorted = sorter.sortList(head);
		sorted.print();
		
		head = new ListNode(2);
		head.addNode(3).addNode(1).addNode(1).addNode(2);
		head.print();
		sorted = sorter.sortList(head);
		sorted.print();	
		
		head = new ListNode((int)((float)Math.random()*100));
		ListNode current = head;
		for(int i=1;i<100;i++) {
			current = current.addNode((int)((float)Math.random()*100));
		}
		head.print();
		sorted = sorter.sortList(head);
		sorted.print();
		
	}

}
