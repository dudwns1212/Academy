package myjdbc;

public class Scopetest {
	public static void main(String[] args) {
		a();
	}

	private static void a() {
		b();
		
	}

	private static void b() {
		int count = 500;
		System.out.println(count);
		
	}
}
