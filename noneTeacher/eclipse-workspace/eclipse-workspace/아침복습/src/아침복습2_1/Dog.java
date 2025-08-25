package 아침복습2_1;

import 아침복습2.Animal;

public class Dog extends Animal {
	
	public Dog() {
		System.out.println("자식생성자가 생성되었습니다");
	}
	public Dog(String name) {
		System.out.println("정수형 자식생성자가 생성되었습니다");
		this.name = name;
	}
	
	public void brith() {
		System.out.println("자식이 태어났어요.");
	}
	
}
