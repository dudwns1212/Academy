package com.lx.sea;

public class Fish extends Sea{
	
	public String name;
	
	public static int count;
	
	public Fish() {
		count++;
	}
	
	public Fish(String name) {
		count++;
		this.name = name;
	}
	
}
