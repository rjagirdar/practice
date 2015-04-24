package arrays;

public class IntegerPartitioning {

	public static void main(String[] args) {
		integerPartition(5);
	}
	
	private static void printTable(int[] table, int k){
		for(int i=0; i<=k; i++){
			System.out.print(table[i]+" ");
		}
		System.out.println();
	}
	
	private static void integerPartition(int n){
		int table[] = new int[n];
		table[0] = n;
		int k = 0;
		int rem_val =0;
		while(true){
			printTable(table, k);
			rem_val=0;
			while(k>=0 && table[k]==1){
				rem_val++;
				k--;
			}
			
			if(k<0)
				return;
			
			table[k]-=1;
			rem_val++;
			
			while(rem_val>table[k]){
				table[k+1] = table[k];
				rem_val-=table[k];
				k++;
			}
			table[k+1] = rem_val;
			k++;
		}
	}

}
