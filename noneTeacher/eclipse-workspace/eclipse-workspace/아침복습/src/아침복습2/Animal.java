package 아침복습2;

public class Animal {
	
	public String name;
	public int age;
	public Animal() {
		System.out.println("부모생성자가 생성되었습니다");
	}
	public Animal(String name) {
		System.out.println("정수형 부모생성자가 생성되었습니다");
		this.name = name;
	}
	
	public void brith() {
		System.out.println("부모가 태어났어요");
	}
	
}

