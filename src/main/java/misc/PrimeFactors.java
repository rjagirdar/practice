package misc;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

	public static void main(String[] args) {
		
		int n=15;
		
		for(int i=1;i<=100; i++){
		
			System.out.print(i+":");
			for(int factor : getPrimeFactors(i))
				System.out.print(factor+" ");
			System.out.println();
		}
		
		for(int i=500; i<=5000; i++){
			if(isPrime(i)){
				System.out.println(i+" ");
			}
		}
	}
	
	private static List<Integer> getPrimeFactors(int n){
		List<Integer> primeFactors = new ArrayList<Integer>();
		
		if(isPrime(n)){
			primeFactors.add(n);
			return primeFactors;
		}
			
		
		while(n%2==0){
			primeFactors.add(2);
			n=n/2;
		}
		
		for(int i=3; i<=Math.sqrt(n); i=i+2){
			
			while(n%i==0){
				primeFactors.add(i);
				n=n/i;
			}
		}
		
		if(n>2)
			primeFactors.add(n);
		
		return primeFactors;
	}
	
	private static boolean isPrime(int n){
		if(n<=3)
			return n>1;
		if(n%2==0 || n%3==0)
			return false;
		for(int i=5; i*i<=n; i+=6){
			if(n%i==0 || n%(i+2)==0)
				return false;
		}
		return true;
	}

}
