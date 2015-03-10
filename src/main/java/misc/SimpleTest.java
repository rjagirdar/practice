package misc;

public class SimpleTest {

	public static void main(String[] args) {
		char bolts[] = {'$', '%', '&', '^', '@', '#'};
		char nuts[] = {'@', '#', '$', '%', '^', '&'};
		for(int val : bolts){
			System.out.print(val+" ");
		}
		System.out.println();
		
		for(int val : nuts){
			System.out.print(val+" ");
		}
	}

}
