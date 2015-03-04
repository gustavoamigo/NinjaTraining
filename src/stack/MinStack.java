package stack;

/**
 * https://oj.leetcode.com/problems/min-stack/
 * @author Gustavo
 *
 */
public class MinStack {

	class Node {
        int value;
        Node greaterNode;
        Node lowerNode;
    }
    
    Node top;
    Node minNode;
    
    public void push(int x) {
    	Node newNode = new Node();
    	newNode.value = x;
    	if(top == null ) 
		{
    		minNode = newNode;
    		top = newNode;
		}
    	else {
    		newNode.lowerNode = top;
    		top = newNode;
    		if(newNode.value < minNode.value)
    			{ 
    				newNode.greaterNode = minNode;  
    				minNode = newNode;
    			}
    	}
        
    }

    public void pop() {
    	if( top != null ) {
    		if(top == minNode)  minNode = minNode.greaterNode;
    		top = top.lowerNode;
    	}
    }

    public int top() {
    	if(top == null) return 0;
        return top.value;
    }

    public int getMin() {
    	if(minNode == null) return 0;
        return minNode.value;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
