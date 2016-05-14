package numberOf1;

public class NumberOf1 {
	public static void main(String[] args){
		int[] nums = new int[]{1, 0x7FFFFFFF, 0x80000000, 0xFFFFFFFF, 0};
		Solution2 solution = new Solution2();
		for(int i: nums){
			System.out.println("the number of 1 of " + i + ": " + solution.numberOf1(i));
		}
	}
}

class Solution2 {
	public int numberOf1(int n){
//		if(n == 0x80000000) return 1;
		int count = 0;
		while(n != 0){
			count++;
			n = (n - 1) & n;
		}
		return count;
	}
}





class Solution1 {
	public int numberOf1(int n){
		int flag = 1;
		int count = 0;
		while(flag > 0){
			if((n & flag) > 0) count++;
			flag = flag << 1;
		}
		if((n & 0x80000000) == 0x80000000) count++;
		return count;
	}
}