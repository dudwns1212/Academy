
public class Project2 {

	public static void main(String[] args) {
		
		Person person1 = new Person("홍길동", 24, "010-0000-0000");
		Person person2 = new Person("춘향이", 20, "010-1111-1111");
		Person person3 = new Person("심청이", 23, "010-2222-2222");
		
		Dog dog1 = new Dog("검둥이");
		Dog dog2 = new Dog("흰둥이");
		Dog dog3 = new Dog("누룽이");
		
		Cat cat1 = new Cat("야옹이");
		Cat cat2 = new Cat("춘복이");
		Cat cat3 = new Cat("알레스카");
		
		House house1 = new House("아파트", person1, dog1, cat1);
		House house2 = new House("빌라", person2, dog2, cat2);
		House house3 = new House("오피스텔", person3, dog3, cat3);

		
		System.out.println("첫 번째 집 이름: " + house1.name + "\n집 안에 있는 사람의 이름: " + house1.person.name + ", 나이: " + house1.person.age + ", 전화번호: " + house1.person.number + "\n집 안에 있는 강아지의 이름: " + house1.dog.name + "\n집 안에 있는 고양이의 이름: " + house1.cat.name);
		System.out.println("\n두 번째 집 이름: " + house2.name + "\n집 안에 있는 사람의 이름: " + house2.person.name + ", 나이: " + house2.person.age + ", 전화번호: " + house2.person.number + "\n집 안에 있는 강아지의 이름: " + house2.dog.name + "\n집 안에 있는 고양이의 이름: " + house2.cat.name);
		System.out.println("\n세 번째 집 이름: " + house3.name + "\n집 안에 있는 사람의 이름: " + house3.person.name + ", 나이: " + house3.person.age + ", 전화번호: " + house3.person.number + "\n집 안에 있는 강아지의 이름: " + house3.dog.name + "\n집 안에 있는 고양이의 이름: " + house3.cat.name);

		
		
	}


}
