package minOfStack;

import java.util.Stack;

public class MinOfStack {
	public static void main(String[] args) throws Exception{
		Solution solution = new Solution();
		solution.push(4);
		System.out.println(solution.min());
		solution.push(3);
		System.out.println(solution.min());
		
	}
}


class Solution{
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> min = new Stack<Integer>();
	
	public void push(int node){
		if(stack.isEmpty()){
			stack.push(node);
			min.push(node);
		}else{
			stack.push(node);
			int temp = min.peek();
			min.push((temp < node)? temp: node);
		}
	}
	
	public int pop() throws Exception{
		if(!stack.isEmpty()){
			min.pop();
			return stack.pop();
		}else{
			throw new Exception("stack is empty");
		}
	}
	
	public int min() throws Exception{
		if(!min.isEmpty()){
			return min.peek();
		}else{
			throw new Exception("stack is empty");
		}
	}
}