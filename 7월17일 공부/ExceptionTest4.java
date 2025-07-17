package myjdbc;

public class ExceptionTest4 {
	public static void main(String[] args)  {
		
			print();
			
	}

	private static void print() {
		try {
			printHello(-5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void printHello(int count) throws Exception { // throws라는 절로 정의되어 있어서
		if(count<=0) throw new Exception("마이너스는 안되거든요!");
		for(int i=0;i<count;i++) {
			System.out.println("Hello");	
		}
		
		
	}
}
