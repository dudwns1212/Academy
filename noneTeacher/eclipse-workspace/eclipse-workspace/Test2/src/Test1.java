// 변수 선언
public class Test1 {

	public static void main(String[] args) {
		
		System.out.println("안녕하세요!");
		
		// 변수 만들기
		String name1; //문자 자료형 String
		name1 = "홍길동1"; // = -> 오른쪽에 있는 값을 왼쪽의 변수에 대입한다
		
		int age1;
		// System.out.println(age1); => 오류발생 int 값이 선언되지 않았음
		age1 = 21;
		
		// 변수명으로 출력
		System.out.println(name1); 
		System.out.println(age1);
		
		// 변수 만들기2
		String name2 = "홍길동2";
		int age2 = 22;
		System.out.println(name2);
		System.out.println(age2);
		
		// 변수 합치기 (+연산자)
		int age3 = 10;
		int age4 = 20;
		int age5 = age3 + age4; /* == int age5; 
		                              age5 = age3 + age4;   */
		System.out.println(age3 + age4);
		System.out.println(age5);
		
		String output1 = name2 + age2; // 문자형과 정수형을 더함
		System.out.println(output1); // 숫자 22를 글자 "22"로 바꿔서 붙임
		
		
		
		
		
		
		
		
	}

}
