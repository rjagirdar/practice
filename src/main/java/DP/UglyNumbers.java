package DP;

public class UglyNumbers {

	public static void main(String[] args) {
		nthUglyNumber(11);
	}
	
	private static int nthUglyNumber(int n){
		int[] table = new int[n+1];
		table[0] =1;
		int i_2=1,i_3=1,i_5=1;
		
		for(int i=1; i<=n; i++){
			int next_2 = 2*i_2;
			int next_3 = 3*i_3;
			int next_5 = 5*i_5;
			
			int next = min(next_2,next_3,next_5);
			
			table[i] = next;
			
			if(next == next_2)
				i_2++;
			if(next == next_3)
				i_3++;
			if(next == next_5)
				i_5++;
		}
		
		
		
		
		printSeries(table);
		return table[n];
	}
	
	private static void printSeries(int[] table){
		for(int i=0; i<table.length; i++){
			System.out.print(table[i]+"    ");
		}
		System.out.println();
		System.out.println("======================================");
	}
	
	private static int min(int a, int b, int c){
		int temp=Integer.MAX_VALUE;
		temp = Math.min(a, b);
		return Math.min(temp, c);
	}

}
