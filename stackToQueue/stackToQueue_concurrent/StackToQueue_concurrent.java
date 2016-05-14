package stackToQueue_concurrent;

//用两个栈实现队列 —— 多线程模式下

import java.util.Stack;

public class StackToQueue_concurrent {
	public static void main(String[] args){
		Solution queue = new Solution();
		new Producer(queue).start();
		new Producer(queue).start();
		new Consumer(queue).start();
		new Consumer(queue).start();
	}
}

class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public synchronized void push(int node) {
        stack1.push(node);
        notifyAll();
    }
    
    public synchronized int pop() {
    	int result = 0;
    	if(!stack2.isEmpty()) result = stack2.pop();
    	else{
    		if(stack1.isEmpty()){
    			try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}else{
    			while(!stack1.isEmpty()) stack2.push(stack1.pop());
    			result = stack2.pop();
    			notifyAll();
    		}
    	} 
        return result;
    }
    
    public boolean isEmpty(){
    	return stack1.isEmpty() && stack2.isEmpty();
    }
}

class Producer extends Thread{
	private Solution queue;
	public Producer(Solution queue){
		this.queue = queue;
	}
	public void run(){
		for(int i = 0; i < 5; i++){
			queue.push(i);
			System.out.println(Thread.currentThread().getName() + " push " + i);
		}
	}
}

class Consumer extends Thread{
	private Solution queue;
	public Consumer(Solution queue){
		this.queue = queue;
	}
	public void run(){
		while(true){
			System.out.println(Thread.currentThread().getName() + " pop " + queue.pop());
		}
	}
}






