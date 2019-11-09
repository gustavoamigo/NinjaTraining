package fb;

// https://leetcode.com/explore/interview/card/facebook/6/linked-list/319/
class LinkedListAddTwoIntegers {
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

      int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
      int rest = 0;

      if (sum > 9) {
        rest = sum / 10;
        sum = sum - rest * 10;
      }
      if (l1 != null && l1.next != null) {
        l1.next.val = l1.next.val + rest;
        ListNode node = new ListNode(sum);
        node.next = addTwoNumbers(l1.next, l2 != null ? l2.next : null);
        return node;
      } else if (l2 != null && l2.next != null) {
        l2.next.val = l2.next.val + rest;
        ListNode node = new ListNode(sum);
        node.next = addTwoNumbers(l1 != null ? l1.next : null, l2.next);
        return node;
      } else {
        if (rest != 0) {
          ListNode last = new ListNode(rest);
          ListNode beforeLast = new ListNode(sum);
          beforeLast.next = last;
          return beforeLast;
        } else {
          return new ListNode(sum);
        }

      }
    }
  }
}
