package misc;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		System.out.println(gcd(54, 13));
	}
	
	private static int gcd(int num1, int num2){
		
		int a, b;
		if(num1>num2){
			a=num1;b=num2;
		}
		else{
			a=num2;b=num1;
		}
		
		while(b>0){
			int temp = b;
			b=a%b;
			a=temp;
			
		}
		return a;
	}

}
