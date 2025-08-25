package com.lx.animal;

public class Dog extends Animal{
	
	public int age = 0;
	
	// 똑같은 walk 함수를 다시 만들었음 (재정의 override)
	public void walk() {
		System.out.println(this.name + " 강아지가 걸어갑니다.");
	}
	
}
