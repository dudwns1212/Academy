import com.lx.animal.Animal;
import com.lx.cat.Cat;
import com.lx.dog.Dog;
import com.lx.fish.Fish;

public class main1 {
	
	public static void main(String[] args) {
		
		Animal animal1 = new Animal();
		animal1.name = "동물";
		System.out.println(animal1.name);
	//	animal1.age -> 오류
		
		Dog dog1 = new Dog();
		dog1.name = "개";
		System.out.println(dog1.name);
		dog1.age = 2;
		System.out.println(dog1.age);
	//	dog1.mobile -> 오류
		
		Cat cat1 = new Cat();
		cat1.name = "고양이";
		System.out.println(cat1.name);
		cat1.age = 1;
		System.out.println(cat1.age);
		cat1.mobile = "1111";
		System.out.println(cat1.mobile);
		
		dog1.realName();
		cat1.realName();
		
		Fish fish1 = new Fish();
		fish1.name = "물고기";
		fish1.realName();
		
	} 
}
