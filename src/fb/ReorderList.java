package fb;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReorderList {



 public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


    private List<ListNode> partition(ListNode root) {
        ListNode slow = root;
        ListNode fast = root;
        ListNode previous = root;
        while(fast != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next;
            if(fast != null) fast = fast.next;
        }
        ListNode mid = previous.next;
        previous.next = null;
        return Arrays.asList(root, mid);
    }


    private ListNode invert(ListNode root) {
        if(root == null) return null;
        Stack<ListNode> stack = new Stack<>();
        while(root != null) {
            ListNode next = root.next;
            root.next = null;
            stack.add(root);
            root = next;
        }

        ListNode last = stack.pop();
        ListNode previous = last;
        while(!stack.isEmpty()) {
            ListNode node = stack.pop();
            previous.next = node;
            previous = node;
        }

        return last;
    }

    private ListNode removeLast(ListNode root) {
        if(root == null) return null;
        ListNode previous = null;
        while(root.next != null){
            previous = root;
            root = root.next;
        }
        previous.next = null;
        return root;
    }

    private void merge(ListNode left, ListNode right) {
        ListNode l = left;
        ListNode r = right;
        while(l != null) {
            ListNode lnext = l.next;
            ListNode rnext = r != null ? r.next : null;
            l.next = r;
            if(r != null) r.next = lnext;
            r = rnext;
            l = lnext;
        }
    }

    public void reorderList(ListNode head) {
        if(head == null) return;
        List<ListNode> partition = partition(head);
        ListNode left = partition.get(0);
        ListNode right = partition.get(1);
        merge(left, invert(right));
    }
}
