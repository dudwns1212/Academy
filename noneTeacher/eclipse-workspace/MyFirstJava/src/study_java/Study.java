package study_java;

public class Study {
	public static void main(String[] args) {
		System.out.println("공부를 시작합니다.");
		String doll = "bear";
		String doll_1 = "bear";
		System.out.println(doll==doll_1); // 둘의 주소값이 같은 doll과 doll_1 모두 같은 bear를 가리킴
		String doll_2 = new String("bear");
		System.out.println(doll==doll_2); // new String을 통해 새로운 주소의 bear를 생성함 = 둘의 주소값이 다름
		System.out.println(10&2); // 0011과 0010 and비트연산
		System.out.println(10|2); // 0011과 0010 or비트연산 후 
		System.out.println(10^2); // 서로 다른 경우만 ture 따라서 8
		String s = "I like Java";
		System.out.println(s.length()); //11
		System.out.println(s.toUpperCase()); 
		System.out.println(s.toLowerCase());
		System.out.println(s.contains("Java"));
		System.out.println(s.indexOf("a")); // a가 두개지만 첫 a의 위치정보
		System.out.println(s.lastIndexOf("a")); // 마지막 a의 위치정보
		System.out.println(s.startsWith("I like"));
		System.out.println(s.endsWith("."));
		System.out.println(s.replace("like", "love"));
		System.out.println(s.substring(7));
		String t = "   I like Java   ";
		System.out.println(t);
		System.out.println(t.trim());
		System.out.println(s.concat(" and Python"));
		int i = 0;
		if(i<0) {
			System.out.println("i는 0보다 작아요.");
		}else if(i>0) {
			System.out.println("i는 0보다 커요.");
		}else {
			System.out.println("i는 0이에요.");
		}
		// else는 마지막에 한번만 사용가능 
		int menu = 1; // 게임메뉴: 시작(1) 종료(2)
		switch(menu) {
		case 1:System.out.println("starts");
		break;//만약 1이면 아래로 내려가지 않고 종료
		case 2:System.out.println("ends");
		break; // 만약 2면 아래로 내려가지 않고 종료
		default:System.out.println("code error"); //모두 아니라면 default 실행
		}
		//안녕을 5번 출력하세요
		for(int h=0;h<5;h++) {
			System.out.print("안녕");
		}
		//반복문으로 구구단 만들기
		System.out.println("구구단을 외우자");
		for(int e=1;e<10;e++) {
			System.out.println("["+e+"단]");
			for(int r=1;r<10;r++) {
				int n = e*r;
				System.out.println(e+"x"+r+"="+n);
			}
			System.out.println("");
		}
		int e=0;
		while(e<=3) {
			System.out.println("정답입니다");
			e++;
		}
		do {
			System.out.println(e);
			e++;
		}while(e<10);
		
	}
}
/* 자료형 
 정수형: int(4byte) long(8byte)
 실수형: float(4byte) double(8byte)
 논리형: boolean(1byte)
 글자1개- char(1byte)   
 
 변수 선언 방법
 1.자료형 변수명 = 값;
 String name = 고영준;
 int clock = 5;
 float score = 4.5;
 
 2.자로형 변수명;
   변수명=값;
 String name;
 name = 고영준;
 
 변수 규칙 
 1.밑줄(_), 문자, 숫자 사용가능, 공백 불가
 2.밑줄 또는 문자로 시작가능, 숫자시작 불가
 3.소문자로 시작하고 나머지 단어의 첫 글자는 대문자 ex) myName, strongMan
 4.예약어(public,static,void ...)는 사용 불가
 
 상수 = const
 final 자료형 변수명 = 값; => 상수는 변경 불가
 final int hour = 5;
 hour = 20; (x) 변경x
 
 형 변환 - (자료형) 변수명 or 값;
 int score=93; -> float score_f=(float) score;  변수를 넣어 실수변환
 int score=93; -> double score_d=(double)93    값을 넣어 실수변환
 이러한 경우를 묵시적 형 변환이라고 함, 묵시적 형 변환은 자료형을 생략가능 즉 float score_f = score; o
 묵시적 -> int - long - float - double 
 명시적 형 변환은 반대의 경우로 자료형 생략 불가능 반드시 입력해야함.
 명시적 -> double - float - long - int
 
 연산자
 -산술 연산자
 + - * / % ++ -- 아는 내용이므로 패스
 -대입 연산자
 =, +=, -=, *=, /=, %=
 -비교 연산자
 >, <, >=, <=, ==(같은지 비교, 같으면 true), !=(다른지 비교, 다르면 ture)
 -논리 연산자
 &&(and), ||(or), !(not) 
 -삼항 연산자
 조건?a:b -> 조건이 참이면 a, 거짓이면 b
 -비트 연산자 
 & , | , ^ 비트연산은 2진수으로 변환하여 연산 후 10진수로 출력 
 
 문자열 기능(명령문)
 length(길이) toUpperCase(대문자변환) toLowerCase(소문자변환) contains(포함여부) indexOf(위치정보) lastIndexOf(마지막위치정보) 
 startsWith endsWith replace substring trim concat
 
 문자열 비교 
 == 주소값 비교
 equals 문자값 비교
 
 특수문자
 \n 줄바꿈 \t 탭 \\ 역슬래시출력 \" 큰따옴표출력 \' 작은따옴표출력
 
 조건문 if(조건){명령문}
 반복문 for(선언;조건;증감){명령문1;명령문2;} 
 
 
 */
