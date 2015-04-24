package DP;

public class EditDistance {

	public static void main(String[] args) {
		String X = "ABC";
		String Y = "XYZ";
		System.out.println("Min Edits to convert "+X+" into "+ Y+" is "+editDistance(X, Y));
	}
	
	private static int editDistance(String X, String Y){
		int[][] table = new int[X.length()+1][Y.length()+1];
		
		table[0][0] =0;
		for(int j=1; j<=Y.length(); j++)
			table[0][j] = j;
		for(int i=1; i<=X.length(); i++)
			table[i][0] = i;
		
		for(int i=1; i<=X.length(); i++){
			for(int j=1; j<=Y.length(); j++){
				int leftCell = table[i][j-1]+1;
				int topCell = table[i-1][j]+1;
				int cornerCell = table[i-1][j-1]+(X.charAt(i-1)==Y.charAt(j-1)?0:1);
				
				table[i][j] = Math.min(cornerCell, Math.min(leftCell, topCell));
			}
		}
		
		return table[X.length()][Y.length()];
	}

}
