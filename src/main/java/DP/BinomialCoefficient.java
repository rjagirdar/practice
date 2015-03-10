package DP;

public class BinomialCoefficient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(binomialCoefficient(4, 2));
	}
	
	private static void printTable(int[][] table){
		for (int i = 0; i < table.length; i++) {
		    for (int j = 0; j < table[0].length; j++) {
		        System.out.print(table[i][j] + "   ");
		    }
		    System.out.print("\n");
		}
		System.out.println("====================================================");
	}
	
	private static int binomialCoefficient(int n, int k){
		if(k>n)
			return -1;
		
		int[][] table = new int[n+1][k+1];
		
		for(int i=0; i<=n; i++){
			for(int j=0; j<=Math.min(i, k); j++){
				if(j==0 || j==i)
					table[i][j] = 1;
				else
					table[i][j] = table[i-1][j-1] + table[i-1][j];
			}
		}
		printTable(table);
		return table[n][k];
	}

}
