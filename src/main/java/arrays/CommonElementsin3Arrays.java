package arrays;

public class CommonElementsin3Arrays {

	public static void main(String[] args) {
		int ar1[] = {1, 5, 10, 20, 40, 80};
	    int ar2[] = {6, 7, 20, 80, 100};
	    int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};
	    findCommon(ar1, ar2, ar3);
	    
	}
	
	private static void findCommon(int[] a, int[] b, int[] c){
		int i=0,j=0,k=0;
		
		while(i<a.length && j<b.length && k<c.length){
			if(a[i]==b[j] && b[j]==c[k]){
				System.out.println("Triplet Found "+a[i]+" & "+b[j]+" & "+c[k]);
				i++;j++;k++;
			}
			else if(a[i]<b[j])
				i++;
			else if(b[j]<c[k])
				j++;
			else
				k++;
		}
	}

}
