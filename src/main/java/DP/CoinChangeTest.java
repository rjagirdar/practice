package DP;

public class CoinChangeTest {

	public static void main(String[] args) {
		int[] coins = {1,2,3};
		CoinChange cc = new CoinChange(coins);
		System.out.println(cc.numOfWays(6));
	}
	
	private static class CoinChange{
		private int[] coins;
		
		public CoinChange(int[] arr){
			this.coins = arr;
		}
		
		public void printTable(int[][] table){
			for (int i = 0; i < table.length; i++) {
			    for (int j = 0; j < table[0].length; j++) {
			        System.out.print(table[i][j] + "   ");
			    }
			    System.out.print("\n");
			}
		}
		
		public int numOfWays(int target){
			int[][] table = new int[target+1][coins.length+1];
			
			for(int j=0; j<coins.length+1; j++)
				table[0][j] =1;
			
			for(int i=1; i<target+1; i++)
				table[i][0] =0;
			
			for(int i=1; i<target+1; i++){
				for(int j=1; j<coins.length+1; j++){
					
					/*Calculate Exclusion value*/
					int y = table[i][j-1];
					
					/*Calculate Inclusion Value*/
					int x = 0;
					if(i>=this.coins[j-1]){
						x+= table[i-coins[j-1]][j];
					}
					
					table[i][j] = x+y;
					
				}
			}
			
			printTable(table);
			System.out.println("=================================");
			return table[target][coins.length];
		}
	}

}
