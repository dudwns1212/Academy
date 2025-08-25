/* class 영역 -> main 영역(a,b,c)
			 -> 다른 기능을 하는 함수 영역(a,b,c)  
			   a,b,c는 각 영역마다 다른 값    */


public class Test1{// main 함수상자 - 프로그램을 실행하라고 하면 컴퓨터가 이 함수상자를 실행해 줌
	public static void main(String[] args) {
		int a = 10;
		int b = 3;
		// 함수상자들 실행
		System.out.println(add(a,b));
		System.out.println(minus(a,b));
		System.out.println(divide(a,b));
		System.out.println(multyply(a, b));
		System.out.println(molla(a,b));
		
		// print1 함수 실행
		print1();
		
		// walk 함수 실행
		walk(8);
		walk(9);
		
	}
	
	// void는 리턴하지 않음
	static void walk (int speed) {
		System.out.println(speed + "km 속도로 걸어갑니다.");
	}
	
	// 콘솔에 출력하는 함수상자
	static void print1() {
		System.out.println("print1 함수가 실행되었어요.");
	}
	
	// 함수상자 -> 함수(입구){출구}
	static int add(int a, int b) {// main의 a와 함수상자의 a는 다름 따라서 13이 아닌 30이 출력
		a=20;
		b=10;
		return a + b;
	}
	
	static int minus(int c, int d) {// main의 변수와 minus
		return c - d;
	}
	
	static int divide(int a, int b) {
		
		return a / b;
	}
	
	static int multyply(int a, int b) {
		return a * b;
	}
	
	static int molla(int a, int b) {
		return a%b;
	}
	
	
}
