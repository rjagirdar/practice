package arrays;

public class MissingNumberFromAP {

	public static void main(String[] args) {
		int[] arr = {2,4,6,10,12,14,16};
		
		System.out.println(missingNumber(arr));
	}
	
	private static int missingNumber(int[] ap){
		
		int difference = (ap[ap.length-1]-ap[0])/ap.length;
		if(difference==ap[1]-ap[0])
			return missingNumber(ap,0,ap.length-1,difference);
		else
			return -1;
	}
	
	private static int missingNumber(int[] ap, int l, int r, int diff){
		
		while(r-l>1){
			int mid = l+(r-l)/2;
			if(ap[mid] <= ap[0]+mid*diff){
				l=mid;
			}
			else
				r=mid;
		}
		return ap[r]-diff;
	}

}
