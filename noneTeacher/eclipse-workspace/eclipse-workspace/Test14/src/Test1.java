
public class Test1 {

	public static void main(String[] args) {
		
		IAnimal dog1 = new Dog();  // 약속을 지킨 애들만 쓰겠다는 의미
		dog1.setName("검둥");
		dog1.run();
		
		// 상속과 비슷함 하지만 물려줄 수 없고 생성하라고 명령만 하는 느낌
		// implements를 쓰면 약속받은 클래스는 약속(함수,변수) 등을 직접 설정해야함
		
		

	}

}
