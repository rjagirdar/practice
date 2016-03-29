package arrays;

public class CountNumberofIslands {

	public static void main(String[] args) {
		 int[][] mat =  {{'O', 'O', 'O'},
                 		 {'X', 'X', 'O'},
                 		 {'X', 'X', 'O'},
                 		 {'O', 'O', 'X'},
                 		 {'O', 'O', 'X'},
                 		 {'X', 'X', 'O'}
               };
		 System.out.println(countIslands(mat));
	}
	
	private static int countIslands(int[][] arr){
		int count = 0;
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[0].length; j++){
				if(arr[i][j] == 'X'){
					if((i==0 || arr[i-1][j] == 'O') && (j==0 || arr[i][j-1] == 'O'))
						count++;
				}
				
			}
		}
		
		return count;
	}

}
