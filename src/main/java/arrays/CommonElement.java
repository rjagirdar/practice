package arrays;

import java.util.Arrays;

public class CommonElement {
	
	

	public static void main(String[] args) {
		 int[][] mat = { 	{1, 2, 3, 5, 6},
                 			{2, 4, 5, 8, 10},
                 			{3, 5, 7, 9, 11},
                 			{1, 3, 5, 7, 9},
               		   };
		 System.out.println(findCommon(mat));
	}
	
	private static int findMinElementRow(int[][] mat,int[] colIndexes){
		int min = mat[0][colIndexes[0]];
		int min_Index = 0;
		for(int i=1; i<colIndexes.length; i++){
			if(mat[i][colIndexes[i]] < min){
				min = mat[i][colIndexes[i]];
				min_Index = i;
			}
		}
		return min_Index;
	}
	
	private static void decreaseIndex(int[][] mat, int[] colIndexes,int index){
		int key = mat[index][colIndexes[index]];
		for(int i=0; i<colIndexes.length; i++){
			if(index!=i && mat[i][colIndexes[i]] !=key){
				colIndexes[i] -=1;
			}
		}
	}
	
	private static boolean allElementsSame(int[][] mat, int[] colIndexes){
		int element = -1;
		for(int i=0; i<colIndexes.length; i++){
			if(colIndexes[i] == -1){
				return false;
			}
			else {
				if(element==-1){
					element = mat[i][colIndexes[i]];
				}
				else{
					if(element!=mat[i][colIndexes[i]])
						return false;
				}
			}
		}
		
		return true;
	}
	
	
	private static int findCommon(int[][] mat){
		int[] colIndexes = new int[mat.length];
		Arrays.fill(colIndexes, mat[0].length-1);
		int min_row = 0;
		while(colIndexes[min_row]>=0){
			if(allElementsSame(mat, colIndexes)){
				return mat[min_row][colIndexes[min_row]];
			}
			else{
				min_row = findMinElementRow(mat, colIndexes);
				decreaseIndex(mat, colIndexes, min_row);
			}
		}
		if(colIndexes[min_row]>=0)
			return mat[min_row][colIndexes[min_row]];
		else
			return -1;
	}
	
	

}
