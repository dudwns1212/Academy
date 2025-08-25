package com.lx.Fish;

public class Shark extends Fish {
	// 상속으로 Fish의 name과 age가 들어있음
	public String mobile;
	
	// 부모에게 이미 있는 함수를 덮어쓰기
	public void swim() {
		System.out.println("이름이 " + this.name + "인 상어빵이 헤엄칩니다.");
	}
	
	
}
