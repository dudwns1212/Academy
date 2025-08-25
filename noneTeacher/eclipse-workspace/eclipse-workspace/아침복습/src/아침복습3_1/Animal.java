package 아침복습3_1;

import java.util.HashMap;

public class Animal {
	
	String name; 
	public String birth;
	
	HashMap<String,Animal> animals = new HashMap<String,Animal>();
	
	public Animal() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public Animal(String name) {
		this.name = name;
	}
	
	
	public void run() {
		System.out.println(this.name + "뛰어다닙니다.");
	}
	
	public void walk() {
		System.out.println(this.name + "걸어다닙니다.");
	}
	
	
	
}
