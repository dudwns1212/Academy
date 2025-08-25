import java.util.ArrayList;

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
		
		ArrayList <Dog> dogs = new ArrayList<>();
		dogs.add(dog1);
		dogs.add(dog2);
		dogs.add(dog3);
		
		ArrayList <Cat> cats = new ArrayList<>();
		cats.add(cat1);
		cats.add(cat2);
		cats.add(cat3);
		
		House house1 = new House("아파트", person1, dog1, cat1, dogs, cats);
		House house2 = new House("빌라", person2, dog2, cat2, dogs, cats);
		House house3 = new House("오피스텔", person3, dog3, cat3, dogs, cats);

		
		System.out.println("첫 번째 집 이름: " + house1.name + "\n집 안에 있는 사람의 이름: " + house1.person.name + ", 나이: " + house1.person.age + ", 전화번호: " + house1.person.number + "\n집 안에 있는 강아지의 이름: " + house1.dog.name + "\n집 안에 있는 고양이의 이름: " + house1.cat.name);
		System.out.println("\n두 번째 집 이름: " + house2.name + "\n집 안에 있는 사람의 이름: " + house2.person.name + ", 나이: " + house2.person.age + ", 전화번호: " + house2.person.number + "\n집 안에 있는 강아지의 이름: " + house2.dog.name + "\n집 안에 있는 고양이의 이름: " + house2.cat.name);
		System.out.println("\n세 번째 집 이름: " + house3.name + "\n집 안에 있는 사람의 이름: " + house3.person.name + ", 나이: " + house3.person.age + ", 전화번호: " + house3.person.number + "\n집 안에 있는 강아지의 이름: " + house3.dog.name + "\n집 안에 있는 고양이의 이름: " + house3.cat.name);
		System.out.println(dogs.get(0).name);
		System.out.println(((Cat)cats.get(0)).name);
		System.out.println(cats.get(0).name);
		System.out.println();
		
		ArrayList <String> names = new ArrayList<>();
		names.add("홍길동1");
		names.add("홍길동2");
		names.add("홍길동3");
		names.add("홍길동4");
		
		System.out.println("names 안에 만들어진 칸의 개수: " + names.size());
		System.out.println("names 안에 있는 칸 중에서 두번째 칸에 들어있는 이름은?: " + names.get(1)); 
		System.out.println("names 안에 있는 값 중 홍길동4의 자리는?: " + names.indexOf("홍길동4"));
		System.out.println(names);
		
		for(int i=0;i<names.size();i++) {
			System.out.println("names의 " + i + "인덱스에 해당하는 칸의 값: " + names.get(i));
		}
		
	}


}
