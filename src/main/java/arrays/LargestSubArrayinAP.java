package arrays;

public class LargestSubArrayinAP {

	public static void main(String[] args) {
		int[] arr = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
		largestSubArrayinAP(arr);
	}
	
	private static int largestSubArrayinAP(int[] arr){
		
		int min, max, start=-1,end=-1;
		int max_len=Integer.MIN_VALUE;
		for(int i=0; i<=arr.length-1; i++){
			
			min=arr[i];max=arr[i];
			
			for(int j=i+1; j<=arr.length-1; j++){
				if(arr[j]>max){
					max = arr[j];
				}
				else if(arr[j]<min){
					min = arr[j];
				}
				
				if(max-min == j-i){
					max_len = Math.max(max_len, j-i+1);
					start = i;
					end=j;
				}
				
			}
		}
		
		for(int i=start; i<=end; i++){
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		System.out.println(max_len);
		return max_len;
	}

}
