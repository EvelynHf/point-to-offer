package queueToStack;

//��������ʵ��һ��ջ ���� ���߳�ģʽ

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack_single {
	public static void main(String[] args){
		Solution stack = new Solution();
		for(int  i = 0; i < 10; i++){
			stack.push(i);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
}

class Solution{
	private Queue<Integer> queue1 = new LinkedList<Integer>();
	private Queue<Integer> queue2 = new LinkedList<Integer>();

	public void push(int node){
		if(!queue1.isEmpty()) queue1.offer(node);
		else queue2.offer(node);
	}
	public int pop(){
		if(!queue1.isEmpty()){
			while(queue1.size() > 1){
				queue2.offer(queue1.poll());
			}
			return queue1.poll();
		}else if(!queue2.isEmpty()){
			while(queue2.size() > 1){
				queue1.offer(queue2.poll());
			}
			return queue2.poll();
		}else{
			return -1;
		}
	}
	public boolean isEmpty(){
		return queue1.isEmpty() && queue2.isEmpty();
	}
}