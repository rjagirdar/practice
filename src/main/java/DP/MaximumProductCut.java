package DP;

public class MaximumProductCut {

	public static void main(String[] args) {
		System.out.println(maximumProductCut(10));
	}
	
	public static int maximumProductCut(int n){
		if(n<2)
			return -1;
		int[] table = new int[n+1];
		table[0] =0;
		table[1] =0;
		table[2]=1;
		for(int i=3; i<=n; i++){
			int max_product = Integer.MIN_VALUE;
			for(int j=1; j<i; j++){
				max_product = Math.max(max_product, j*Math.max(i-j, table[i-j]));
			}
			table[i] = max_product;
		}
		
		return table[n];
		
	}

}
