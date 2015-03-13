package misc;

public class GenericClass {

	public static void main(String[] args) {
		Test<String> i1 = new Test<String>();
		i1.setT("Raghuveer Jagirdar");
		i1.print();
		
		Test<Integer> i2 = new Test<Integer>(20);
		i2.print();
		
		Test<Sample> i3 = new Test<GenericClass.Sample>(new Sample());
		i3.print();
		
		
		
	}
	
	private static class Sample{
		@Override
		public String toString() {
			return "Hello Raghuveer from class Sample";
		}
	}
	
	private static class Test<T> {
		private T member;
		
		public Test(T data){
			this.member = data;
		}
		
		public Test(){
			this.member = null;
		}
		
		public T getT(){
			return member;
		}
		
		public void setT(T data){
			this.member = data;
		}
		
		public void print(){
			System.out.println(this.member);
		}
	}

}
