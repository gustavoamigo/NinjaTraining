package fb;

import java.util.HashMap;
// https://leetcode.com/explore/interview/card/facebook/6/linked-list/3020/
class CopyRandomLists {
  class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val, Node _next, Node _random) {
      val = _val;
      next = _next;
      random = _random;
    }
  }

  private HashMap<Node, Node> created = new HashMap<>();

  public Node copyRandomList(Node head) {

    Node currentOld = head;
    Node currentNew = null;
    Node clonedHead = null;

    while (currentOld != null) {
      Node clonedNode = copy(currentOld);
      clonedNode.random = copy(currentOld.random);
      if (clonedHead == null) { clonedHead = clonedNode; }
      if (currentNew != null) { currentNew.next = clonedNode; }
      currentNew = clonedNode;
      currentOld = currentOld.next;
    }

    return clonedHead;
  }

  private Node copy(Node old) {
    if (old == null) { return null; }
    if (created.get(old) == null) {
      Node cloned = new Node();
      cloned.val = old.val;
      created.put(old, cloned);
    }
    return created.get(old);
  }
}
