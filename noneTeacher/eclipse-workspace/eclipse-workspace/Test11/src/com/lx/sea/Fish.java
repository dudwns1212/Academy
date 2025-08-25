package com.lx.sea;

public class Fish {
	
	public String name;
	
	public Fish(String name) {
		Sea.count = Sea.count + 1;
		this.name = name;
	}
}
