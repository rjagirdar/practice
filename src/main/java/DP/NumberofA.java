package DP;

public class NumberofA {

	public static void main(String[] args) {
		System.out.println(numofA(7));
	}
	
	private static int numofA(int N){
		
		int[] screen = new int[N];
		
		if(N<=6)
			return N;
		for(int i=1; i<=6; i++){
			screen[i-1] = i;
		}
		
		for(int n=7; n<=N; n++){
			
			screen[n-1] = 0;
			for(int b=n-3; b>=1; b--){
				int curr = (n-b-1)*screen[b-1];
				if(curr>screen[n-1])
					screen[n-1] = curr;
			}
		}
		return screen[N-1];
	}

}
