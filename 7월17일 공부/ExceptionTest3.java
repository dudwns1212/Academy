package myjdbc;

public class ExceptionTest3 {
	public static void main(String[] args) {
		try {
			print();
		} catch (RuntimeException e) {
			
		}
		
	}

	private static void print() throws RuntimeException {
		if(true) throw new RuntimeException("haha");
		
	}
}
