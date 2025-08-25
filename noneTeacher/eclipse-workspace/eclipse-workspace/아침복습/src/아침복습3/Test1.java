package 아침복습3;

import 아침복습3_1.Animal;
import 아침복습3_1.Cat;
import 아침복습3_1.Dog;

public class Test1 {
	
	public static void main(String[] args) {
		
		// 변수상자
		String name;
		name = "홍길동1";
		
		int age1 = 21;
		
		System.out.println(name + age1);
		
		// 함수상자
		Test1 test1 = new Test1();
		System.out.println(test1.add(10,20));  // non-static -> 객체필요
		System.out.println(minus(10,20));  // static -> 같은 스태틱에서는 이름만으로 호출
		
		test1.walk(); // non-static
		run();  // static
		
		Animal animal1 = new Animal("동물1");
		System.out.println("붕어빵의 이름 : " + animal1.getName());
		
		Dog dog1 = new Dog("강아지1");
		dog1.run();
		dog1.walk();
		
		Cat cat1 = new Cat("고양이1");
		cat1.run();
		
		System.out.println("강아지의 출생년도 : " + dog1.birth);
		
		
		
		
	}
	
	int add(int a, int b) {
		return a + b;
	}
	
	static int minus(int a, int b) {
		return a - b;
	}
	
	void walk() {
		System.out.println("걸어요");
	}
	
	static void run() {
		System.out.println("뛰어요");
	}
	
}
