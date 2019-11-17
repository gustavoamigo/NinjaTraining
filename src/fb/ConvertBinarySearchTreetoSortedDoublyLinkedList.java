package fb;

// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/544/
class ConvertBinarySearchTreetoSortedDoublyLinkedList {

  class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
      val = _val;
      left = _left;
      right = _right;
    }
  };

  Node head = null;
  Node previous = null;
  Node tail = null;

  public Node treeToDoublyList(Node root) {
    if(root == null) return null;
    if(tail == null) {
      if(root.right == null) {
        tail = root;
      } else {
        tail = root.right;
        while(tail != null && tail.right != null) tail = tail.right;
      }
    }

    Node resultLeft = treeToDoublyList(root.left);

    boolean isRoot = false;

    // visit
    if(head == null) {
      head = root;
      isRoot = true;
      head.left = tail;
      if(tail != null) tail.right = head;
    }

    if(previous != null) {
      previous.right = root;
      root.left = previous;
    }

    previous = root;

    Node resultRight = null;

    if(root.right != head) {
      resultRight = treeToDoublyList(root.right);
    }

    if(isRoot) {
      return head;
    } else {
      return resultLeft != null ? resultLeft : resultRight;
    }
  }
}
