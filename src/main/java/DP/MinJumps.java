package DP;

public class MinJumps {

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		//arr = new int[]{1, 3, 6, 1, 0, 9};
		System.out.println(numOfJumps(arr));
	}
	
	private static int numOfJumps(int[] arr){
		int[] table = new int[arr.length+1];
		table[0] = 0;
		int unreachable = Integer.MAX_VALUE;
		
		for(int i=1; i<=arr.length; i++){
			
			table[i] = unreachable;
			
			for(int j=0; j<i; j++){
				
				if(i<=j+arr[j] && table[j]!= unreachable){
					table[i] = Math.min(table[i], table[j]+1);
					break;
				}
			}
				
		}
		return table[arr.length];
	}

}


