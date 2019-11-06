package fb;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/277/
class CloneGraph {

  class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  };

  HashMap<Integer, Node> createdNode = new HashMap<>();

  public Node cloneGraph(Node node) {
    if(createdNode.get(node.val) == null) {
      List<Node> newNeighbors = new LinkedList<Node>();
      createdNode.put(node.val, new Node(node.val, new LinkedList<>()));
      for(Node neighbor: node.neighbors) newNeighbors.add(cloneGraph(neighbor));
      createdNode.get(node.val).neighbors.addAll(newNeighbors);
    }

    return createdNode.get(node.val);
  }
}
