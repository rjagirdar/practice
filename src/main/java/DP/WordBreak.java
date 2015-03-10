package DP;

import java.util.HashSet;

public class WordBreak {
	
	static HashSet<String> dictionary = new HashSet<String>();
	
	static {
		dictionary.add("mobile");
		dictionary.add("samsung");
		dictionary.add("sam");
		dictionary.add("sung");
		dictionary.add("man");
		dictionary.add("mango");
		dictionary.add("icecream");
		dictionary.add("and");
		dictionary.add("go");
		dictionary.add("i");
		dictionary.add("like");
		dictionary.add("ice");
		dictionary.add("cream");
		dictionary.add("ilike");
		dictionary.add("ilikesamsung");
	}
	
	public static void main(String[] args){
		
		String str = "ilikesamsung";
		System.out.println(wordbreak(str));
		
		
	}
	
	private static boolean search(String subString){
		System.out.println(subString);
		return dictionary.contains(subString);
	}
	
	private static boolean wordbreak(String str){
		
		if(str.length()==0){
			System.out.println("The String "+str+" cannot be broken into dictionary words");
			return false;
		}
		
		boolean[] table = new boolean[str.length()+1];
		
		for(int i=1; i<=str.length(); i++){
			
			if(search(str.substring(0, i))){
				table[i] = true;
			}
			
			if(table[i]){
				
				if(i==str.length())
					return true;
				
				for(int j=i+1; j<=str.length(); j++){
					
					if(table[j] == false && search(str.substring(i, j))){
						table[j] = true;
					}
					
					if(j==str.length() && table[j] == true)
						return true;
					
				}
			}
			
			
		}
			
		return false;
	}
}
