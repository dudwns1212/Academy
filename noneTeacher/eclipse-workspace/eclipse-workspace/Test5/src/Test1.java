
public class Test1 {

	public static void main(String[] args) {
		
		// new를 통해 새로운 변수상자를 만듦 
		Fish fish1 = new Fish(); 
		
		// 구조체 변수상자에 값을 넣기
		fish1.name = "붕어빵1";
		fish1.age = 1;
		
		System.out.println("붕어빵의 이름: " + fish1.name);
		System.out.println("붕어빵의 나이: " + fish1.age);
		
	}

}
