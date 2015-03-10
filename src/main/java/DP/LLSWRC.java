package DP;

import java.util.HashMap;

public class LLSWRC {

	public static void main(String[] args) {
		String input = "SHASHAANKAR";
		System.out.println(findLLSWRC(input));
	}
	
	private static int findLLSWRC(String str){
		HashMap<Character, Integer> map = new HashMap<>();
		int cur_len=0,max_len=Integer.MIN_VALUE;
		
		int start =-1,end=-1;
		int tempStart =0, tempEnd = -1;
		boolean start_occurred = false; 
		for(int i=0; i<str.length(); i++){
			int previous=-1;
			
			if(map.containsKey(str.charAt(i))){
				previous = map.get(str.charAt(i));
				if(i-cur_len > previous){
					cur_len++;
				}
				else{
					tempEnd = i-1;
					if(cur_len>max_len){
						max_len = cur_len;
						start = tempStart;
						end = tempEnd;
					}
					cur_len=1;
					tempStart = i;
				}
			}
			else{
				cur_len++;
				if(!start_occurred){
					tempStart = i;
					start_occurred = true;
				}
			}	
			map.put(str.charAt(i), i);
		}
		
		System.out.println(str.substring(start, end+1));
		return max_len;
	}

}
