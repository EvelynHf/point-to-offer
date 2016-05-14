package minNumberInRotateArray;

public class MinNumberInRotateArray {
	public static void main(String[] args){
		int[] array1 = new int[]{716,726,894,895,912,299,382,538};
		int[] array2 = new int[]{3, 4, 5, 5, 1, 1, 1, 2};
		int[] array3 = new int[]{};
		int[] array4 = new int[]{1, 2, 3, 4};
		int[] array5 = new int[]{1, 2, 3, 1, 1};
		int[] array6 = new int[]{1, 1, 1, 0, 1};
		int[] array7 = new int[]{1, 0, 1, 1, 1};
		Solution solution = new Solution();
		System.out.println("min in array1: " + solution.minNumberInRotateArray(array1));
		System.out.println("min in array2: " + solution.minNumberInRotateArray(array2));
		System.out.println("min in array3: " + solution.minNumberInRotateArray(array3));
		System.out.println("min in array4: " + solution.minNumberInRotateArray(array4));
		System.out.println("min in array5: " + solution.minNumberInRotateArray(array5));
		System.out.println("min in array6: " + solution.minNumberInRotateArray(array6));
		System.out.println("min in array7: " + solution.minNumberInRotateArray(array7));

	}
}

class Solution{
	public int minNumberInRotateArray(int[] array){
		return minNumberInRotateArray(array, 0, array.length - 1);
	}
	public int minNumberInRotateArray(int[] array, int start, int end){
		if(start > end) return 0;
		if(start == end || array[start] < array[end]) return array[start];
		if(start == end - 1) return array[end];
		int index = (end - start) / 2;
		if(array[start] == array[start + index] && array[end] == array[start + index]){
			for(int i = start + 1; i <= end; i++){
				if(array[i - 1] > array[i]) return array[i];
			}
			return array[start];
		}else{
			if(array[start] <= array[start + index]) return minNumberInRotateArray(array, start + index, end);
			else return minNumberInRotateArray(array, start, start + index);
		}
	}
}