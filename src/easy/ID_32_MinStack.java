package easy;

import java.util.Stack;

public class ID_32_MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class MinStack {
		
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> minNumStack = new Stack<Integer>();
		
	    public void push(int x) {
	        stack.push(x);
	        int minNum = Integer.MAX_VALUE;
	        if(!minNumStack.isEmpty()) {
	        	minNum = minNumStack.peek();
	        }
	        if(x < minNum) {
	        	minNumStack.push(x);
	        }
	        else {
	        	minNumStack.push(minNum);
	        }
	    }

	    public void pop() {
	        stack.pop();
	        minNumStack.pop();
	    }

	    public int top() {
	        return stack.peek();
	    }

	    public int getMin() {
	        return minNumStack.peek();
	    }
	}

}
