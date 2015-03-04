package list;

public class SingleLinkedList {
	private ListNode head;
		
	class ListNode {
		public Integer val;
		public ListNode next;
		public ListNode(Integer value) {
			this.val = value;
		}
	}

	public SingleLinkedList() {
	}
	
	public SingleLinkedList add(Integer value) {
		ListNode item = new ListNode(value);
		if(head == null) {
			head = item;
		} else {
			item.next = head;
			head = item;
		}
		return this;
	}
	
	private void deleteNextNode(ListNode node){
		// Nothing to do here
		if(node.next == null) throw new IllegalArgumentException("There is no next node");
		if(node.next != null) {
			node.next = node.next.next;
		} else {
			node.next = null;
		}
	}
	
	public void maintainWhileDelete(int m, int n) {
		ListNode node = head;
		ListNode nodeBefore = null;
		while (node.next != null) {
			
			// Maintain M
			for(int i=0; i < m && node.next != null; i++) {
				nodeBefore = node;
				node = node.next;
			}
			
			// Delete N
			for(int i=0; i < n && node.next != null; i++) {
				node = node.next;
				nodeBefore.next = node;
			}
		}
	}
	
	public SingleLinkedList removeDuplicates() {
		
		// Nothing to do here
		if(head.next == null) return this;
		
		ListNode current = head;
		ListNode nodeBefore = null;
		
		while(current != null) {
			ListNode sucessor = current.next;
			boolean unique = true;
			
			// Check if future nodes are equal to the current one
			while(sucessor != null) {
				if(current.val.equals(sucessor.val)) {
					unique = false;
					break;
				}
				sucessor = sucessor.next;
			}
			if(!unique) {
				ListNode nodeToDelete = current;

				// removes head value
				if(nodeBefore == null) {
					head = current.next;
					current = current.next;
				} else {
					deleteNextNode(nodeBefore);
					current = current.next;
				}
				
				// Let's free any references so GC can do its work
				nodeToDelete.next = null; 
			} else {
				nodeBefore = current;
				current = current.next;
			}	
		}
		return this;
	}
	
	public void printList() {
		ListNode current = head;
		while (current != null){
			System.out.print("'" + current.val + "'" + (current.next != null? ",":""));
			current = current.next;
		}
		System.out.print("\n");
	}
	
	public SingleLinkedList insertionSortList() {
		this.head = insertionSortList(head);
		return this;
	}
	
	
    public ListNode insertionSortList(ListNode head) {
        
        if(head == null) return null;
        if(head.next == null) return head;
        
        int i = 1;
        ListNode current = head.next;
        ListNode beforeCurrent = head;
        while(current!=null) {
        	ListNode back = head;
        	ListNode beforeBack = null;

        	int j = 0;
        	boolean found = false;
        	while(j<i) {
        		if(current.val < back.val) {
        			found = true;
        			// delete current from actual position
        			ListNode next = current.next;
        			beforeCurrent.next = next;
        			
        			// Insert before back
        			if(beforeBack == null) {
        				current.next = head;
        				head = current;
        			} else {
        				beforeBack.next = current;
        				current.next = back;
        			}
        			beforeBack = current;
        			j++;
        			current = next;
        			break;
        		}
        		beforeBack = back;
        		back = back.next;
        		j++;
        	}
        	if(found == false) {
        		beforeCurrent = current;
        		current = current.next;
        	}
        	i++;
        }
        return head;
    }

	static public void main (String[] args) {
		
//		SingleLinkedList list = new SingleLinkedList();
//		list.add(3).add(3).add(4).add(2).add(1).add(2).printList();
//		list.removeDuplicates().printList();
//		
//		SingleLinkedList list2 = new SingleLinkedList();
//		list2.add(2).add(3).add(4).add(2).add(5).add(2).printList();
//		list2.removeDuplicates().printList();
		
		SingleLinkedList list3 = new SingleLinkedList();
		list3.add(77).add(83).printList();
		list3.insertionSortList().printList();
		
		SingleLinkedList list4 = new SingleLinkedList();
		for(int i=5; i > 0; i--) {
		    int r = (int)(Math.random()*100);
			list4.add(r);
		}
		list4.printList();
		list4.insertionSortList().printList();
		
	}
}