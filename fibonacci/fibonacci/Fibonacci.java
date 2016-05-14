package fibonacci;

public class Fibonacci {
	public static void main(String[] args){
		int[] nums = new int[]{0, 1, 2, 7, 8, 50, 100};
		for(int i: nums){
			System.out.println(new Solution().fibonacci(i));
		}		
	}
}

class Solution{
	public long fibonacci(int n){
		long[] result = new long[]{0, 1};
		if(n < 2) return result[n];
		for(int i = 2; i <= n; i++){
			long temp = result[0] + result[1];
			result[0] = result[1];
			result[1] = temp;
		}
		return result[1];
	}
}
