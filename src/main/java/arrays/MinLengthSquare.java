package arrays;

public class MinLengthSquare {

	public static void main(String[] args) {
		System.out.println(ml(11));
	}
	
	private static boolean isSquare(int n){
		int root = (int) Math.sqrt(n);
		int square = (int)Math.pow(root, 2);
		if(square==n)
			return true;
		else
			return false;
		
	}
	
	private static int ml(int n){
		int[] arr = new int[n+1];
		
		arr[1] =1;
		int last_square_encountered = 1;
		int i;
		for(i=2; i<=n; i++){
			if(isSquare(i)){
				arr[i] = 1;
				last_square_encountered=(int)Math.sqrt(i);
			}
			else{
				int a = 1+arr[i-1];
				int b = Integer.MAX_VALUE;
				for(int j=last_square_encountered; j>=1; j--){
					    int last_square = (int)Math.pow(j,2);
						b = Math.min(b, 1+arr[i-last_square]);
				}
				arr[i] = Math.min(a, b);
			
			}
				
		}
		
		
		return arr[n];
	}

}
