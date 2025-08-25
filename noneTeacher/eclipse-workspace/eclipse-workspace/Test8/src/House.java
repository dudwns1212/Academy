import java.util.ArrayList;
public class House{
	
	String name;
	Person person;
	Dog dog;
	Cat cat;
	ArrayList dogs;
	ArrayList cats;
	
	House(String name, Person person, Dog dog, Cat cat, ArrayList dogs, ArrayList cats){
		this.name = name;
		this.person = person;
		this.dog = dog;
		this.cat = cat;
		this.dogs = dogs;
		this.cats = cats;
	}
	
}
