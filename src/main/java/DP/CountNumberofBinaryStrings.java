package DP;

public class CountNumberofBinaryStrings {

	public static void main(String[] args) {
		int n = 2;
		countBinaryStringWithNoConsecutiveOnes(n);
	}
	
	private static void countBinaryStringWithNoConsecutiveOnes(int n){
		int[] zero = new int[n+1];
		int[] one = new int[n+1];
		zero[1] = 1;
		one[1] = 1;
		for(int i=2; i<=n; i++){
			int temp = zero[i-1];
			zero[i] = zero[i-1]+one[i-1];
			one[i] = temp;
		}
		System.out.println(zero[n]+one[n]);
	}

}
