package binarytree;
import java.util.*;
/*
 * https://oj.leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {
	
	static class Node<T> {
		private T value;
		private List<Node<T>> children;
		
		public Node(T v) {
			this.value = v;
			this.children = new LinkedList<Node<T>>(); 
		}
		
		public T getValue() {
			return this.value;
		}
		
		public List<Node<T>> getChildren() {
			return this.children;
		}
		
		public Node<T> addChild(Node<T> node) {
			getChildren().add(node);
			return node;
		}
		
		public Node<T> addSibling(Node<T> node) {
			getChildren().add(node);
			return this;
		}
	}
	
	static public class SimpleTree<T> {
		
		private Node<T> root;
		private Integer maxDepth;
		
		public SimpleTree(Node<T> r) {
			this.root = r;
		}
		
		public Node<T> getRoot() {
			return this.root;
		}
		
		public boolean isBalanced() {
			return isBalancedRecursive(root, 0);
		}
		
		private boolean isBalancedRecursive(Node<T> currentNode, int nodeDepth) {
			boolean isBalanced = true;
			if(currentNode.getChildren().size() > 0) {
				for(Node<T> childNode : currentNode.getChildren()) {
					if(!isBalancedRecursive(childNode, nodeDepth++)) {
						isBalanced = false;
					};
				}
			} else { // it is leaf
				if(maxDepth == null) { // means it's the first leaf it encounters
					maxDepth = nodeDepth;
				} else { // means it's not the first leaf
					// multiply twice so we can get rid of the signal
					if(((maxDepth - nodeDepth) * (maxDepth - nodeDepth)) > 1) {
						isBalanced = false;
					}
				}
			}
			return isBalanced;
		}
	}	
	


	public static void main(String[] args) {
		SimpleTree<String> balancedTree = new SimpleTree<String>(new Node<String>("A"));
		balancedTree.getRoot().addChild(new Node<String>("B")).addSibling(new Node<String>("D")).addSibling(new Node<String>("E"));
		balancedTree.getRoot().addChild(new Node<String>("C")).addSibling(new Node<String>("F"));
		
		System.out.println("Is tree balanced :=" + (balancedTree.isBalanced()?"yes":"no"));
		
		SimpleTree<String> unBalancedTree = new BalancedBinaryTree.SimpleTree<String>(new Node<String>("A"));		
		unBalancedTree.getRoot().addChild(new Node<String>("B")).addSibling(new Node<String>("D")).addSibling(new Node<String>("E"));
		unBalancedTree.getRoot().addChild(new Node<String>("C")).addSibling(new Node<String>("F")).addChild(new Node<String>("G")).addChild(new Node<String>("H"));
		
		System.out.println("Is tree balanced :=" + (unBalancedTree.isBalanced()?"yes":"no"));
	}
}
