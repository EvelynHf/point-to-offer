package print1ToMaxOfNDigits;

public class Print1ToMaxOfNDigits {
	public static void main(String[] args){
		int n = 2;
		Solution2 solution = new Solution2();
		solution.print1ToMaxOfNDigits(n);
	}

}


//全排列
class Solution2 {
	public void print1ToMaxOfNDigits(int n){
		if(n < 1) return;
		char[] array = new char[n];
		print1ToMaxOfDigitsRecursively(array, n, 0);
	}
	private void print1ToMaxOfDigitsRecursively(char[] array, int len, int index){
		if(index == len){
			printNum(array);
			return;
		}
		for(int i = 0; i < 10; i++){
			array[index] = (char) ('0' + i);
			print1ToMaxOfDigitsRecursively(array, len, index + 1);
		}
	}
	private void printNum(char[] array){
		int index = 0;
		while(index < array.length && array[index] == '0'){ 
			index++;
		}
		if(index < array.length){
			while(index < array.length){
				System.out.print(array[index]);
				index++;
			}
			System.out.println();
		}
	}
}




//模拟加法
class Solution{
	public void print1ToMaxOfNDigits(int n){
		if(n < 1) return;
		StringBuilder num = new StringBuilder();
		num.append('0');
		while(!increment(num, n)){
			printNum(num);
			System.out.println();
		}
	}
	
	private boolean increment(StringBuilder num, int n){
		boolean isOverflow = false;
		int nTakeOver = 0;
		int nSum = 0;
		for(int i = num.length() - 1; i >= 0; i--){
			nSum = num.charAt(i) - '0' + nTakeOver;
			nTakeOver = 0;
			if(i == num.length() - 1) nSum++;
			if(nSum >= 10){
				nTakeOver = 1;
				num.setCharAt(i, (char) ('0' + (nSum - 10)));
			}else{
				num.setCharAt(i, (char) ('0' + nSum));
			}
		}
		if(nTakeOver == 1){
			if(n == num.length()){
				isOverflow = true;
			}else{
				num.insert(0, '1');
			}
		}
		return isOverflow;
	}
	
	private void printNum(StringBuilder num){
		for(int i = 0; i < num.length(); i++){
			System.out.print(num.charAt(i));
		}
	}

}