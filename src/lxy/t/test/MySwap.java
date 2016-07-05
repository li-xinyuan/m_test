package lxy.t.test;

public class MySwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a = 1, b = 2;
		System.out.println("before : a=" + a + ",b=" + b);
		swap(a, b);
		System.out.println("before : a=" + a + ",b=" + b);
	}

	public static void swap(Integer a, Integer b) {
		Integer temp = new Integer(a.intValue());
		b = new Integer(temp);
		Integer temp2 = new Integer(b.intValue());
		a = new Integer(temp2);
	}
}
