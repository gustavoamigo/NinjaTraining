package fb;

class MergeTwoLists {
  static public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 != null && l2 != null) {
      if(l1.val <= l2.val) {
        ListNode node = new ListNode(l1.val);
        node.next = mergeTwoLists(l1.next, l2);
        return node;
      } else {
        ListNode node = new ListNode(l2.val);
        node.next = mergeTwoLists(l1, l2.next);
        return node;
      }
    } else if(l1 != null && l2 == null) {
      ListNode node = new ListNode(l1.val);
      node.next = mergeTwoLists(l1.next, null);
      return node;
    } else if(l1 == null && l2 != null) {
      ListNode node = new ListNode(l2.val);
      node.next = mergeTwoLists(l2.next, null);
      return node;
    } else {
      return null;
    }
  }

  public static ListNode create(int ... nums) {
    ListNode root = null;
    ListNode current = null;
    for(int i : nums) {
      ListNode node = new ListNode(i);
      if(root == null) root = node;
      if(current != null) current.next = node;
      current = node;
    }
    return root;
  }

  public static void main(String[] args) {
    ListNode l1 = create(1,2,3);
    ListNode l2 = create(1,2,4);
    ListNode listNode = new MergeTwoLists().mergeTwoLists(l1, l2);
  }
}
