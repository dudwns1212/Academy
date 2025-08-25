package com.lx;

import project4.Animal;
import project4.Cat;
import project4.Dog;

public class Project4 {
	
	public static void main(String[] args) {
		
		Animal animal1 = new Dog();
		animal1.setName("강아지");;
		
		
		animal1.run();
		animal1.standup();
		animal1.sitdown();
		
		Animal animal2 = new Cat();
		animal2.setName("고양이");
		
		animal2.run();
		animal2.standup();
		animal2.sitdown();
		
		Animal dog1 = new Dog();
		Animal dog2 = new Dog();
		Animal cat1 = new Cat();
		Animal cat2 = new Cat();
		
		// 동물의 총 마리 수 출력
		System.out.println("동물은 총 몇 마리 인가요? : " + Animal.count);
	}
	
}
