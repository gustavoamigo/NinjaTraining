package fb;

class MergeKLists {
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) { return null; }
    if (lists.length == 1) { return lists[0]; }
    if (lists.length == 2) {
      return mergeTwoLists(lists[0], lists[1]);
    }

    int half = lists.length / 2;
    int rest = lists.length % 2;
    ListNode[] left = new ListNode[half + rest];
    ListNode[] right = new ListNode[half];
    for (int i = 0; i < left.length; i++) { left[i] = lists[i]; }
    for (int i = 0; i < right.length; i++) { right[i] = lists[i + left.length]; }
    ListNode leftNode = mergeKLists(left);
    ListNode rightNode = mergeKLists(right);
    return mergeTwoLists(leftNode, rightNode);
  }


  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        ListNode node = new ListNode(l1.val);
        node.next = mergeTwoLists(l1.next, l2);
        return node;
      } else {
        ListNode node = new ListNode(l2.val);
        node.next = mergeTwoLists(l1, l2.next);
        return node;
      }
    } else if (l1 != null && l2 == null) {
      ListNode node = new ListNode(l1.val);
      node.next = mergeTwoLists(l1.next, null);
      return node;
    } else if (l1 == null && l2 != null) {
      ListNode node = new ListNode(l2.val);
      node.next = mergeTwoLists(l2.next, null);
      return node;
    } else {
      return null;
    }
  }

  public ListNode create(int... nums) {
    ListNode root = null;
    ListNode current = null;
    for (int i : nums) {
      ListNode node = new ListNode(i);
      if (root == null) { root = node; }
      if (current != null) { current.next = node; }
      current = node;
    }
    return root;
  }

  private Character toLower(Character a) {
    if(a >= 'A' && a <= 'Z') {
      int z = a - 'A' + 'a';
      return (char) z;
    } else return a;
  }
}
