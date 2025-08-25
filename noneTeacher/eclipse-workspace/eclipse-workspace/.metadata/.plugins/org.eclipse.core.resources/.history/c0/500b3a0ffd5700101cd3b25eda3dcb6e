package 아침복습2;

import java.util.ArrayList;

import com.lx.animal.Animal;
import com.lx.animal.Cat;
import com.lx.animal.Dog;
import com.lx.person.Person;

public class Test1 {
	
	// String name2 = "홍길동2";  선언을 위한 코드
	// name2 = "홍길동3"; 오류발생/ 실행을 위한 코드는 항상 함수상자 안에 있어야함
	// System.out.println("ddd");  프린트함수도 마찬가지로 실행코드
	
	// static int count = 0;
	
	public static void main(String[] args) { // 메인도 함수상자다
		// 변수상자
		String name = "홍길동";
		int age1 =21;
		boolean isPerson = true;
		float weight = 80.5f;  // float는 값 뒤에 f를 붙여야 오류가 발생하지 않음
		double weight2 = 80.5; // 왜나면 소수를 지칭하는 자료형이 2개라서 (float, double)
		System.out.println(name + age1 + isPerson + weight + weight2);
		
		int output1 = age1 + 20; 
		System.out.println("더하기 결과 : " + output1);
		
		// 함수상자 실행하기
		int output2 = add(age1,10);
		System.out.println("함수상자 실행결과 : " + output2);
		walk();  
		print();
		
		// 붕어빵 틀에서 붕어빵 만들기
		Person person1 = new Person();
		person1.name = "홍길동1";
		System.out.println("person1 변수상자에 들어가있는 붕어빵의 이름 : " + person1.name);
		
		Person person2 = new Person("홍길동2");
		System.out.println("person2 변수상자에 들어가있는 붕어빵의 이름 : " + person2.name);
		
		//만들어진 붕어빵(동물)의 개수 저장하기
		// int count = 0;
		
		// 상속 
		Animal animal1 = new Animal();
		//count ++; // count = count +1; 과 같음
//		addCount();
		animal1.name = "동물1";
		animal1.walk();
		
		Dog dog1 = new Dog();
		// count ++;
//		addCount();
		dog1.name = "강아지1";
		dog1.age = 1;
		dog1.walk();
		
		Cat cat1 = new Cat();
		// count ++;
//		addCount();
		cat1.name = "고양이1";
		cat1.run();
		
		// 생성자에 count ++;을 함으로 동물, 동물을 상속받은 다른 강아지 고양이들이 생성될 때마다 count가 1씩 증가
		System.out.println("만들어진 동물 마리수 : " + Animal.count); 
		
		
		// 하나의 변수상자 안에서 여러 칸 만들기
		ArrayList <Animal> animals = new ArrayList <Animal> ();
		animals.add(dog1);
		animals.add(cat1);
		System.out.println("동물 마리수 : " + animals.size());
		
		
		Animal out1 = animals.get(0);
		System.out.println("첫 번째 동물의 이름 : " + out1.name);
		
		Animal out2 = animals.get(1);
		Cat out3 = (Cat) out2;
		out3.run();
		
	}
	// 함수상자 만들기
	static int add(int a, int b) {
		System.out.println("더하기를 시작합니다.");
		return a + b;
	}
	static void walk() {
		System.out.println("걸어다닙니다.");
	}
	static void print() {
		System.out.println("출력합니다.");
	}
	
	
	
}
