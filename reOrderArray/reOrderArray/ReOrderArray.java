package reOrderArray;

public class ReOrderArray {

}

class Solution {
    public void reOrderArray(int [] array) {
        if(array.length <= 1) return;
        int[] odd = new int[array.length];
        int[] even = new int[array.length];
        int oddNum = 0;
        int evenNum = 0;
        for(int i = 0; i < array.length; i++){
            if((array[i] & 1) != 0) odd[oddNum++] = array[i];
            else even[evenNum++] = array[i];
        }
        for(int i = 0; i < oddNum; i++){
            array[i] = odd[i];
        }
        for(int i = 0, index = oddNum; i < evenNum; i++){
            array[oddNum++] = even[i];
        }
         
 
    }
}