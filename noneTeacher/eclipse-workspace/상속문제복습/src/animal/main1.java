package animal;

class Animal {
	
	String name;
	
	public Animal(int a) {
		System.out.println("특별한 생성자가 부모에 잇다?");
	}
	
	public Animal() {
		System.out.println("생성자는 항상 부모부터");
	}
	
	public static void run() {
		System.out.println("동물이 뛰고 있어요.");
	}
}

class Dog extends Animal{
		
	public Dog(int b) {
		System.out.println("특별한 생성자가 자식에 있다?");
	}
	
	public Dog() {
		System.out.println("자식은 그 다음에");
	}
	
	public static void run(){
		System.out.println("강아지가 뛰고 있어요.");
	}
}
public class main1 {
	public static void main(String[] args) {
		Animal animal1 = new Animal();
		Animal animal2 = new Animal(5);
		System.out.println();
		Dog dog1 = new Dog(10);
		Dog dog2 = new Dog();
		System.out.println();
		Animal dog3 = new Dog(10);
		
		dog3.run();
		
	}
}
