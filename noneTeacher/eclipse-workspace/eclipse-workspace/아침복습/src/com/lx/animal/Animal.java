package com.lx.animal;

public class Animal {
	
	// static(전역변수) : 클래스(붕어빵 틀)에 붙어있음, 클래스 변수/메서드   
	// 인스턴스(멤버) 변수/메서드(함수): 다른 변수들(String name 등)은 붕어빵들(animal1... 등)에 들어있음
	// 즉 static은 클래스에 붙고(Animal.count), 다른 인스턴스 변수들은 틀 즉 멤버에 붙음(animal1.count)
	public static int count = 0;
	
	public String name;
	
	// 생성 -> +1
	public Animal() {
		count = count + 1;
	}
	
	public void walk() {
		System.out.println(this.name + "이 걸어갑니다.");
	}
	
	
}
