package com.lx;

public class Fish {
	
	String name;
	
	int age;
	
	
	
	public String getName() { // get 함수 -> 안전하게 가져가기 위한 함수상자
		return name;
	}
	
	public void setName (String name) { // set 함수
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		if (age < 20) {
			System.out.println("미성년자입니다.");
			return; // 더이상 실행되지 않게함, 즉 20미만이라면 나이값이 설정되지 않음(this.age = age; x)
		}
		this.age = age;
	}
	
	public Fish() {
		
	}
	
	public Fish(String name) {
		this.name = name;
	}
}
