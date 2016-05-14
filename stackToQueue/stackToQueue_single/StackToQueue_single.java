package stackToQueue_single;

//用两个栈实现队列 —— 单线程模式下
import java.util.Stack;

public class StackToQueue_single {
	public static void main(String[] args){
		Solution2 queue = new Solution2();
		for(int i = 0; i < 10; i++){
			queue.push(i);
		}
		while(!queue.isEmpty()){
			System.out.println(queue.pop());
		}
		
	}
	
}

class Solution2{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if(!stack2.isEmpty()){
    		return stack2.pop();
    	}else{
    		if(!stack1.isEmpty()){
    			while(!stack1.isEmpty()){
    				stack2.push(stack1.pop());
    			}
    			return stack2.pop();
    		}else{
    			return -1;
    		}
    	}

    }
    public boolean isEmpty(){
    	return stack1.isEmpty() && stack2.isEmpty();
    }
}



class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	int result = -1;
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        if(!stack2.empty()){
            result = stack2.pop();
        }
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}