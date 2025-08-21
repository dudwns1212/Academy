package com.lx.house;

import com.lx.animal.Dog;
import java.util.ArrayList;

public class House {

	String name;
	
	Dog dog;
	
	ArrayList <Dog> dogs = new ArrayList<>();
	
	public void run() {
		if(dogs.size()>0) {
			System.out.println("강아지가 한 마리 이상 있습니다 : " + dogs.getFirst().getName());
		}else {
			System.out.println("강아지가 한 마리도 없습니다.");
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Dog getDog() {
		return dog;
	}
	
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
	public ArrayList<Dog> getDogs() {
		return dogs;
	}
	
	public void setDogs(ArrayList<Dog> dogs) {
		this.dogs = dogs;
	}
	
	public House() {
		
	}
	
	public House(String name, Dog dog, ArrayList<Dog> dogs) {
		this.name = name;
		this.dog = dog;
		this.dogs = dogs;
	}

}
