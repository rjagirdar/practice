package arrays;

public class Factorial {

	public static void main(String[] args) {
		factorial(1000);
	}
	
	private static void factorial(int n){
		int[] result = new int[10000];
		result[0] = 1;
		int res_size = 1;
		for(int i=2; i<=n; i++)
			res_size = multiply(result, res_size, i);
		for(int i=res_size-1; i>=0; i--)
			System.out.print(result[i]);
	}
	
	private static int multiply(int[] res, int res_size, int x){
		int carry = 0;
		int prod = 0;
		for(int i=0; i<res_size; i++){
			prod = res[i]*x+carry;
			res[i] = prod%10;
			carry = prod/10;
		}
		
		while(carry>0){
			res[res_size] = carry;
			carry = carry/10;
			res_size++;
		}
		return res_size;
	}

}
