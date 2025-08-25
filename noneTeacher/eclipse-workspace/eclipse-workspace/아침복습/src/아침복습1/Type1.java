package 아침복습1;

import java.util.ArrayList;

public class Type1 {
	
	public static void main(String[] args) {
		
		// 변수상자 만들기
		String name1;
		name1 = "홍길동1";
		
		String name2 = "홍길동2";
		
		int age1 = 21;
		int age2 = 22;
		
		int output1 = age1 + age2;
		
		System.out.println(name1 + name2);
		System.out.println("더하기 결과 : " + output1);
		
		// 함수상자 실행하기
		print1();
		print2(10);
		int output2 = add(10,30);
		System.out.println("더하기 결과 : " + output2);
		
		// 붕어빵 만들기 
		Fish fish1 = new Fish();
		fish1.name = "물고기1";
		fish1.age = 1;
		
		System.out.println("물고기의 이름 : " + fish1.name);
		
		Person person1 = new Person();
		boolean isPerson = person1.walk(8);
		System.out.println("walk 함수실행 결과 : " + isPerson);
		
		Person person2 = new Person("홍길동2", 22);
		System.out.println("person2의 정보 : " + person2.name + "," + person2.age);
		
		
		Baby baby1 = new Baby();
		baby1.name = "아기물고기1";
		
		fish1.babies.add(baby1);
		fish1.babies.add(new Baby()); // babies -> Baby를 통해 받는 아기물고기 / babies에 add함수를 통해서 바로 Baby를 하나 만들면서 넣어줌
		System.out.println("아기 물고기는 몇 마리? : " + fish1.babies.size());
		
		ArrayList<String>myNickname = new ArrayList<>();
		myNickname.add("마담");
		myNickname.add("아귀");
		myNickname.add("평경장");
		myNickname.add("고니");
		System.out.println(myNickname);
		System.out.println(myNickname.size());
		System.out.println(myNickname.get(1));
		myNickname.add(1, "타짜");
		System.out.println(myNickname.get(1));
		System.out.println(myNickname.get(2));
		
	}
	
	static int add (int a, int b) {
		return a + b;
	}
	
	static void print2(int speed) { 
		System.out.println(speed + "km 속도로 걸어갑니다.");
	}
	
	static void print1() { 
		System.out.println("print1 함수가 실행");
	}
	
}
