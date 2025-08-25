
public class Person {
	
	String name;
	int age;
	String mobile;
	
	Person(){
		
	}
	
	// 생성자
	Person(String name, int age, String mobile){
		this.name=name;
		this.age=age;
		this.mobile=mobile;
	}
	
	void walk() {
		System.out.println("걸어갑니다.");
	}
	
	
	public static void main(String[] args) {
		// 생성자를 이용해 간결하게 표현
		Person person1 = new Person("홍길동1", 21, "010-1000-1000");
		Person person2 = new Person("홍길동2", 22, "010-2000-2000");
		Person person3 = new Person();		

//		person1.name = "홍길동1";
//		person1.age = 21;
//		person1.mobile = "010-1000-1000";

		person3.name = "홍길동3";
		person3.age = 23;
		person3.mobile = "010-3000-3000";
		
		System.out.println("person1의 이름: " + person1.name + ", 나이: " + person1.age + ", 전화번호: " + person1.mobile);
		System.out.println("person2의 이름: " + person2.name + ", 나이: " + person2.age + ", 전화번호: " + person2.mobile);
		System.out.println("person3의 이름: " + person3.name + ", 나이: " + person3.age + ", 전화번호: " + person3.mobile);
		
		person1.walk();
		
	}
}
