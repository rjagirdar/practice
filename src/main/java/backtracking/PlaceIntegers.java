package backtracking;

import java.util.Arrays;

public class PlaceIntegers {

	public static void main(String[] args) {
		int n = 11;
		fill(n);
		
	}
	
	
	private static void fill(int n){
		int[] res = new int[2*n];
		Arrays.fill(res, 0);
		if(fillUtil(res, n, n)){
			for(int val : res){
				System.out.print(val+" ");
			}
		}
		else{
			System.out.println("Arrangement Not possible");
		}
		
	}
	
	private static boolean fillUtil(int[] res, int curr, int n){
		
		if(curr == 0) return true;
		
		for(int i=0; i<2*n-curr-1; i++){
			
			if(res[i] == 0 && res[i+curr+1] == 0){
				
				res[i] = res[i+curr+1] = curr;
				if(fillUtil(res, curr-1, n))
					return true;
				res[i] = res[i+curr+1] =0;
				
			}
		}
		return false;
	}

}
