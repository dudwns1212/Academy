
public class Test1 {

	public static void main(String[] args) {
	
		// if 조건문
		int age1 = 20;
		
		if (age1>20) {
			System.out.println("나이가 20보다 많아요.");
		} else if (age1<20) {
			System.out.println("나이가 20보다 적어요.");
		} else {
			System.out.println("나이가 20이에요.");
		}
		
		// for 반복문
		int count =0;
		count = count + 1;
		count = count + 2;
		count = count + 3;
		count = count + 4;
		count = count + 5;
		count = count + 6;
		count = count + 7;
		count = count + 8;
		count = count + 9;
		count = count + 10;
		System.out.println("1부터 10까지 더한 값 : " + count);
		
		int sum = 0;
		for(int i=0;i<=100;i++) {
			sum += i; // sum = sum + i
		}
		System.out.println("1부터 100까지 더한 값 : " + sum);
		
		// 함수상자 실행 
		int output1 = add(10,20);
		System.out.println(output1);
		
		
		
		
		
	}
	
	// add 함수상자 생성
	static int add (int a, int b) { // 함수상자의 크기는 자료형 int
		int c = a + b;
		return c;
	}
	
}
