package bt;

import java.util.Arrays;

public class HeightofTreeFromParentArray {

	public static void main(String[] args) {
		int[] parent = {1,5,5,2,2,-1,3};
		parent = new int[]{-1, 0, 0, 1, 1, 3, 5};
		System.out.println(depth(parent));
	}
	
	private static int depth(int[] parent){
		int[] temp = new int[parent.length];
		Arrays.fill(temp, -1);
		int max = Integer.MIN_VALUE;
		for(int i=0; i<parent.length; i++){
			if(temp[i]==-1)
				depth(parent,temp,i);
		}
		
		for(int i=0; i<parent.length; i++){
			if(temp[i]>max){
				max = temp[i];
			}
		}
		return max;
	}
	
	private static int depth(int[] parent, int[] temp, int index){
		if(temp[index]!=-1)
			return temp[index];
		if(parent[index] ==-1){
			temp[index] =1;
			return 1;
		}
		else{
			temp[index] =1+depth(parent,temp,parent[index]); 
			return temp[index];
		}
			
	}

}
