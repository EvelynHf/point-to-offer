package isPopRoder;

import java.util.LinkedList;

public class IsPopRoder {
	public static void main(String[] args){
		int[] pushA = {1, 2, 3, 4, 5};
		int[] popA = {2, 1, 3, 4, 5};
		Solution solution = new Solution();
		System.out.println(solution.IsPopOrder(pushA, popA));
	}
}

class Solution {
	public boolean IsPopOrder(int[] pushA, int[] popA){
		
		if(pushA.length == 0 || pushA.length != popA.length){
			return false;
		}

		LinkedList<Integer> stack = new LinkedList<Integer>();
		int i = 0, j = 0; 
		while(i < popA.length){
			while(j < pushA.length && (stack.isEmpty() || stack.peek() != popA[i])) stack.push(pushA[j++]);
			if(stack.isEmpty() || stack.peek() != popA[i]) return false;
			if(stack.peek() == popA[i]){
				stack.pop();
				i++;
			}
		}
		
		if(i == popA.length && stack.isEmpty()) return true;
		else return false;
	}
}