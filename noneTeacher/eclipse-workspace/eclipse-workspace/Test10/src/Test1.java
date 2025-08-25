import java.util.ArrayList;

import com.lx.Fish.Fish;
import com.lx.Fish.Shark;
import com.lx.animal.Animal;
import com.lx.animal.Cat;
import com.lx.animal.Dog;

public class Test1 {
	
	public static void main(String[] args) {
		
		Fish fish1 = new Fish();
		fish1.name = "붕어빵1";
		
		// 상속으로 name변수를 물려받아 사용
		Shark shark1 = new Shark();  
		shark1.name = "상어빵1";
		
		// 상속으로 함수상자를 사용
		fish1.swim();
		shark1.swim();
		
		
		Animal animal1 = new Animal();
		animal1.name = "동물1";
		animal1.walk();
		
		Dog dog1 = new Dog();
		dog1.name = "강아지1";
		dog1.walk();
		dog1.run();
		
		Cat cat1 = new Cat();
		cat1.name = "고양이1";
		cat1.walk();
		
		Animal dog2 = new Animal();
		dog2.name = "강아지2";
		dog2.walk();
		// dog2.run(); dog 클래스 안에 run함수가 있지만 오류가 발생함/ Animal에서 출발했기 때문에 Animal안의 함수,변수들만 사용가능
		// dog2.age() 또한 오류 발생함
		
		Animal cat2 = new Cat();
		
		
		ArrayList<Animal> animals = new ArrayList<Animal>();  // Animal을 상속받은 Dog과 Cat도 배열에 들어갈 수 있음
        animals.add(dog2);                                    // 하지만 강아지나 고양이만이 가진 고유의 함수나 변수는 사용 불가
        animals.add(cat2);
        
//        Animal dog3 = animals.get(0);
//		Animal cat3 = animals.get(1);
		
//		Dog dog4 = (Dog) dog3;
		
		
		
	}
}
