import com.lx.animal.Dog;
import com.lx.house.House;

public class Project3 {

	public static void main(String[] args) {
		Dog dog1 = new Dog("강아지1", 1, "010-1111-1111");
		Dog dog2 = new Dog("강아지2", 2, "010-2222-2222");
		Dog dog3 = new Dog("강아지3", 3, "010-3333-3333");
		
		House house1 = new House();
		house1.getDogs().add(dog1);
		house1.getDogs().add(dog2);
		house1.getDogs().add(dog3);	
				
		System.out.println("집 안에 있는 강아지의 수 : " + house1.getDogs().size());
		
		System.out.print("집 안에 있는 강아지들의 이름 : ");
		for(int i=0;i<house1.getDogs().size();i++) {
			System.out.print(house1.getDogs().get(i).getName());
			if(i<house1.getDogs().size()-1) {
				System.out.print(", ");
			}	
		}
		System.out.println();
		
		System.out.println("마지막 강아지의 이름, 나이, 전화번호 : " + house1.getDogs().getLast().getName() + ", " + house1.getDogs().getLast().getAge() + ", " + house1.getDogs().getLast().getMobile()); 
		
		house1.run();
		House house2 = new House();
		house2.run();
	}

}
