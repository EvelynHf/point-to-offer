package printMatrix;

import java.util.ArrayList;

public class PrintMatrix {

}

class Solution{
	public ArrayList<Integer> PrintMatrix(int[][] matrix){
		if(matrix.length == 0) return new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int n = matrix[0].length;
		int m = matrix.length;
		int count = 0;
		int maxCount = (((m < n)? m: n) - 1) / 2 + 1;
		
		while(count < maxCount){
			//from left to right
			for(int j = count; j <= n - 1 - count; j++){
				list.add(matrix[count][j]);
			}
			//from top to bottom
			for(int i = count + 1; i <= m - 1 - count; i++){
				list.add(matrix[i][n - 1- count]);
			}
			//from right to left
			for(int j = n - 1- count - 1; j >= count && (count != m - 1 - count); j--){
				list.add(matrix[m - 1 - count][j]);
			}
			//from bottom to top
			for(int i = m - 1 - count - 1; i > count && (count != n - 1 - count); i--){
				list.add(matrix[i][count]);
			}
			count++;
			
		}
		return list;
		
	}
}