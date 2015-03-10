package misc;

import java.util.Random;

public class RandomGeneratorTest {

	public static void main(String[] args) {
		int c_0 = 0, c_1=0,c_2=0,c_3=0;
		
		for(int i=1; i<=10000; i++){
			Random rand = new Random();
			int next = rand.nextInt(4);
			if(next == 0)
				c_0++;
			else if(next == 1)
				c_1++;
			else if(next == 2)
				c_2++;
			else if(next == 3)
				c_3++;
		}
		System.out.println("0's Percentage is "+ ((double)(c_0/100)));
		System.out.println("1's Percentage is "+ ((double)(c_1/100)));
		System.out.println("2's Percentage is "+ ((double)(c_2/100)));
		System.out.println("3's Percentage is "+ ((double)(c_3/100)));
	}

}
