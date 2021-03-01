package binarytree;
import java.util.*;
import java.util.Map.Entry;

class BinaryTree<T> {
	static class Node<T> {
		private T value;
		private Node<T> left;
		private Node<T> right;
		
		public Node(T value, Node<T> left, Node<T> right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
		public T getValue() {
			return this.value;
		}
		
		public void setLeft(Node<T> left) {
			this.left = left;
		}
		
		public Node<T> getLeft() {
			return this.left;
		}
		
		public void setRight(Node<T> right) {
			this.right = right;
		}
		
		public Node<T> getRight() {
			return this.right;
		}	

		public void print() {
			print(this, 0);
		}
		
		private void ident(int tabs) {
			for(int i = 0; i<tabs;i++) {
				System.out.print("	");
			}			
		}
		
		private void print(Node<T> node, int level) {
			ident(level); System.out.println("value: "+node.getValue());
			if(node.left != null) 
			{
				ident(level); System.out.println("left: ");
				print(node.left, level+1);
			}
			
			if(node.right != null) 
			{
				ident(level); System.out.println("right: ");
				print(node.right, level+1);
			}
			
		}
		
		@Override
		public boolean equals(Object obj) {
			
			if(obj == null) {
				return false;
			}

			if(!(obj instanceof Node )) { 
				return false;
			}
			
			return this.value.equals(((Node<T>)obj).value);
		}
		
		@Override
		public String toString() {
			return value.toString();
		}
		

	}
	
	private Node<T> root;
	
	public BinaryTree(Node<T> r) {
		this.root = r;
	}
	
	public void setRoot(Node<T> r) {
		this.root = r;
	}
	
	public Node<T> getRoot() {
		return this.root;
	}
	
	public void print() {
		this.root.print();
	}
		
	static private class PassByRefInteger {
		public Integer value;
		public PassByRefInteger(Integer v) {
			this.value = v;
		}
	}
	
	public static <E> BinaryTree<E> create(E value) 
	{
		return null;
	}
	
	public static <T> BinaryTree<T> createBSTFromPreorder(T[] preorder) {
		T[] inorder = preorder.clone();
		Arrays.sort(inorder);
		return new BinaryTree<T>(createBSTFromPreorder(preorder, inorder, new PassByRefInteger(0), 0, preorder.length-1));
	}
	
	private static <T> Node<T> createBSTFromPreorder(T[] preorder, T[] inorder, PassByRefInteger preOrderIndex, int low, int high) {
		
		if(preOrderIndex.value >= preorder.length || low > high) return null;
		
		// Since it is a preorder list, first element is always a root of something
		Node<T> root = new Node<T>(preorder[preOrderIndex.value], null, null);
		preOrderIndex.value++;
		
		if(low == high) return root; // there is nothing more todo
		
		// Find element in the inorder list that is equal to element in the preorder list. 
		int i;
		for(i = low; i<= high; i++) {
			if(inorder[i].equals(root.getValue())) break;
		}
		
		root.setLeft( createBSTFromPreorder(preorder, inorder, preOrderIndex, low, i-1));
		root.setRight( createBSTFromPreorder(preorder, inorder, preOrderIndex, i+1, high));
		return root;
	}
	
	public void inOrder()
	{
		inOrder(root);
	}
	
	private void inOrder(Node<T> node) {
		if(node == null) return;
		inOrder(node.left);
		System.out.print(node.getValue());
		inOrder(node.right);
	}
	

	private void iterativelyInOrder() {
		Stack<Object[]> stack = new Stack<Object[]>();
		
		Object[] firstNode = {root, false};
		stack.push(firstNode);
		
		while(stack.size()!=0) {
			Object[] current = stack.pop();
			Node<T> currentNode = (Node<T>)current[0];
			Boolean isLeftVisited = (Boolean)current[1];
			
			// Visit Left
			if(!isLeftVisited) {
				Object[] visitRoot = {currentNode, true};
				stack.push(visitRoot);
				if(currentNode.getLeft()!=null) {
					Object[] visitLeft = {currentNode.getLeft(), false};
					stack.push(visitLeft);
				}
				continue;
			}
			
			// Visit Root
			System.out.print(currentNode.getValue());
			
			// Visit Right
			if(currentNode.getRight() != null) {
				Object[] visitRight = {currentNode.getRight(), false};
				stack.push(visitRight);
			}
		}
	}
	
	public boolean isBST() {
		valueBefore = null;
		return isBST(root);
	}
	
	private int compare(T valueBefore, T currentValue) {
		return ((Comparable<T>)valueBefore).compareTo(currentValue);
	}
	
	private T valueBefore;
	
	private boolean isBST(Node<T> node) {
		if(node == null) return true;
		boolean isBST = true;
		
		if(!isBST(node.left)) {
			return false;
		}
		
		T currentValue = node.getValue();
		
		if(valueBefore != null) {
			if(compare(valueBefore, currentValue)>=0) {
				return false;
			} 
		} 
		
		valueBefore = currentValue;
		if(!isBST(node.right)) {
			return false;
		}
		
		return true;
	}
	
	public Node<T> nextSucessorPreorder(Node<T> node)
	{
		Stack<Node<T>> stack = new Stack<Node<T>>();
		stack.push(root);
		
		Node<T> current = null;
		Node<T> sucessor = null;
		
		while(stack.size() != 0) {
			Node<T> root = stack.pop();
			if(current != null) {
				sucessor = root;
				break;
			}
			if(current == null && node.equals(root)) current = root;
			if(root.getRight() != null) stack.push(root.getRight());
			if(root.getLeft() != null) stack.push(root.getLeft());
		}
		return sucessor;
	}
	
	public ArrayList<ArrayList<Node<T>>> levelOrder() {
		
		Queue<Node<T>> nodeQueue = new ArrayDeque<Node<T>>();
		Queue<Integer> levelQueue = new ArrayDeque<Integer>();
		
		
		nodeQueue.add(root);
		levelQueue.add(0);
		
		ArrayList<ArrayList<Node<T>>> levels = new ArrayList<ArrayList<Node<T>>>();
		levels.add(new ArrayList<Node<T>>());

		while(nodeQueue.size()!=0) {
			Node<T> current = nodeQueue.poll();
			int currentLevel = levelQueue.poll();
			// Visit Node
			if(levels.size() < currentLevel + 1) {
				levels.add(new ArrayList<Node<T>>());
			}
			levels.get(currentLevel).add(current);
			
			if(current.left != null) {
				nodeQueue.add(current.left);
				levelQueue.add(currentLevel + 1);
			}
			
			if(current.right != null) {
				nodeQueue.add(current.right);
				levelQueue.add(currentLevel + 1);
			}
		}
		
		return levels;
	}
	
	public static void main(String[] args) {

		BinaryTree<String> tree 
			= new BinaryTree<String>(
			new Node<String>("F", 
				new Node<String>("B", 
					new Node<String>("A", null, null),
					new Node<String>("D", 
						new Node<String>("C", null, null),
						new Node<String>("E", null, null))),
				new Node<String>("G",
					null,
					new Node<String>("I",
						new Node<String>("H", null, null),
						null))));
		tree.print();
		
		ArrayList<ArrayList<Node<String>>> levelOrder = tree.levelOrder();
		for(int i=0; i < levelOrder.size(); i++) {
			System.out.println("Level " + i);
			ArrayList<Node<String>> elements = levelOrder.get(i);
			System.out.println(Arrays.toString(elements.toArray()));
		}
		
//		Node<String> next = tree.nextSucessorPreorder(new Node<String>("I", null, null));
//		System.out.println("Next in Preorder :=" + next.value);
		
		
		
		
//		System.out.println("================================");
//		String[] preorder = {"F","B","A","D","C","E","G","I","H"};
//		BinaryTree<String> tree2 = BinaryTree.createBSTFromPreorder(preorder);
//		tree2.print();
		

		
//		System.out.println("Recursive InOrder");
//		tree2.inOrder();
//		
//		
//		System.out.println("\nIterative InOrder");
//		tree2.iterativelyInOrder();
		
//		
//		System.out.println("Is tree2 a BST? " + (tree2.isBST()? "yes":"no"));
//		
//		
//		BinaryTree<String> tree3 
//		= new BinaryTree<String>(
//		new Node<String>("F", 
//			new Node<String>("B", 
//				new Node<String>("A", null, null),
//				new Node<String>("D", 
//					new Node<String>("C", null, null),
//					new Node<String>("E", null, null))),
//			new Node<String>("G",
//				null,
//				new Node<String>("H",
//					new Node<String>("I", null, null),
//					null))));
//		tree3.print();
//		
//		System.out.println("Is tree3 a BST? " + (tree3.isBST()? "yes":"no"));
//		tree3.inOrder();

	}
}