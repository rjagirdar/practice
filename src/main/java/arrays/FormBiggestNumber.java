package arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

public class FormBiggestNumber {

	public static void main(String[] args) {
		List<Integer> list = Lists.newArrayList(54,546,548,60);
		Collections.sort(list, biggestNumberComp);
		for(int val : list){
			System.out.print(val);
		}
	}
	
	private static Comparator<Integer> biggestNumberComp = new Comparator<Integer>() {
		
		@Override
		public int compare(Integer o1, Integer o2) {
			String n1 = String.valueOf(o1);
			String n2 = String.valueOf(o2);
			
			String n1n2 = n1+n2;
			String n2n1 = n2+n1;
			
			Integer iN1N2 = Integer.valueOf(n1n2);
			Integer iN2N1 = Integer.valueOf(n2n1);
			
			if(iN2N1>iN1N2){
				return 1;
			}
			else if(iN2N1<iN1N2){
				return -1;
			}
			else
				return 0;
		}
	};

}
