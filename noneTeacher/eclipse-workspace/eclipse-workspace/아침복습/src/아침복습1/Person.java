package 아침복습1;
// 사람을 위한 붕어빵 틀 만들기
public class Person {

	String name;
	
	int age;
	
	boolean walk(int speed) { // 붕어빵 틀 안에 함수상자
		System.out.println(speed + "km 속도로 걸어갑니다.");
		
		return true;
	}
	
	Person() {
		System.out.println("사람이 만들어졌습니다.");
	}
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
		
		System.out.println("사람이 만들어졌습니다.");
	}
	
}
