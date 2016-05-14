package power;

public class Power {
	public static void main(String[] args){
		double base = -2.0;
		int exponent = 3;
		Solution1 solution = new Solution1();
		System.out.println(solution.power(base, exponent));

	}
}



class Solution2 {
	boolean invalidInput = false;
	public double power(double base, int exponent){
		if(equal(base, 0.0) && exponent < 0){
			invalidInput = true;
			return 0.0;
		}
		int absExponent = exponent;
		if(exponent < 0) absExponent = -exponent;
		double result = powerWithAbsExponent(base, absExponent);
		if(exponent < 0) return 1.0 / result;
		else return result;	
	}
	
	private boolean equal(double num1, double num2){
		if((num1 - num2) > -0.0000001 && (num1 - num2) < 0.0000001) return true;
		else return false;
	}
	
	public double powerWithAbsExponent(double base, int absExponent){
		if(absExponent == 0) return 1;
		if(absExponent == 1) return base;
		double result = powerWithAbsExponent(base, absExponent >> 1);
		result *= result;
		if((absExponent & 0x01) == 1) return result * base;
		else return result;
	}
}




class Solution1 {
	boolean invalidInput = false;
	public double power(double base, int exponent){

		if(equal(base, 0.0) && exponent < 0){
			invalidInput = true;
			return 0.0;
		}
		int absExponent = exponent;
		if(exponent < 0){
			absExponent = -exponent;
		}
		double result = powerWithAbsExponent(base, absExponent);
		if(exponent < 0){
			return 1.0 / result;
		}else{
			return result;
		}
	}
	
	private boolean equal(double num1, double num2){
		if((num1 - num2) > -0.0000001 && (num1 - num2) < 0.0000001) return true;
		else return false;
	}
	
	private double powerWithAbsExponent(double base, int absExponent){
		double result = 1.0;
		for(int i = 1; i <= absExponent; i++){
			result *= base;
		}
		return result;
	}
}