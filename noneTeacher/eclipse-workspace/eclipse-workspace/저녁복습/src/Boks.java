
public class Boks {
	public static void main(String[] args) {
		//변수 선언 방법 2가지
		String name1;
		name1 = "고영준";
		String name2 = "고영준";
		System.out.println(name1 + " " + name2);
		int output = add(10,10);
		System.out.println(output);
		print();
		
		
//if(조건){조건이 참이면 실행}else if(조건2){첫번째 조건이 맞지 않으면서 조건2가 참이면 실행/else if는 여러번 사용 가능}else{모든조건이 맞지 않으면 실행 마지막 한번만 사용가능}
		if(output==20) {
			System.out.println("두 값의 합은 20입니다.");
		}
		
		// for(반복수 조건){반복실행하는 명령문}
		int sum = 0;
		for(int i=0;i<5;i++) {
			sum+=i;
		}
		System.out.println(sum);
		
		
	}
	
	static void print() { // void -> return 값 필요 x
		System.out.println("출력해요.");
	}
	
	
	//변수상자 자료형이 있어서 return값이 필요 ( 클래스 안 + 메인 밖)
	static int add(int a, int b) {
		System.out.println("두 값을 더하겠습니다.");
		return a+b;
	}
	
}
