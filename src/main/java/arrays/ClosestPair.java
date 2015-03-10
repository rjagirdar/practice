package arrays;

public class ClosestPair {

	public static void main(String[] args) {
		int[] arr1 = {1, 4, 5, 7};
		int[] arr2 = {10, 20, 30, 40};
		int x = 38;
		closestpair(arr1, arr2, x);
	}
	
	private static int[] merge(int[] arr1, int[] arr2){
		int[] result = new int[arr1.length+arr2.length-1];
		
		int i=0, j=0;
		int tempIndex =0;
		while(i<arr1.length && j<arr2.length){
			if(arr1[i] < arr2[j]){
				result[tempIndex++] = arr1[i];
			}
			else if(arr1[i] < arr2[j]){
				result[tempIndex++] = arr2[j];
			}
			else{
				result[tempIndex++] = arr2[j];
				i++;j++;
			}
		}
		
		while(i<=arr1.length-1){
			result[tempIndex++] = arr1[i];
		}
		
		while(j<=arr2.length-1){
			result[tempIndex++] = arr2[j];
		}
		return result;
	}
	
	private static void closestpair(int[] arr1, int[] arr2, int x){
		
		int i=0; int j = arr2.length-1;
		
		int diff= Integer.MAX_VALUE;
		
		int a=0,b=0;
		
		while(i<=arr1.length-1 && j>=0){
			
			int tempDiff = Math.abs(x-(arr1[i]+arr2[j]));
			if(tempDiff<diff){
				diff= tempDiff;
				a= i;
				b=j;
			}
			
			if(arr1[i]+arr2[j]>x)
				j--;
			else
				i++;
			
		}
		
		System.out.println(diff);
		System.out.println(arr1[a]+" "+arr2[b]);
	}

}
