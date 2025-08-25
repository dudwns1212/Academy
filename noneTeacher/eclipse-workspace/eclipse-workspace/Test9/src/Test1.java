import com.lx.Fish;
// 서로 다른 패키지에 있는 Fish를 import해서 가져옴 -> 생성자와 변수상자 앞에 public을 붙여서 다른 패키지에서도 사용하게 끔 설정
public class Test1 {

	public static void main(String[] args) {
		
		Fish fish1 = new Fish("물고기1");
		fish1.setAge(10);
		
		System.out.println("fish의 정보 -> 이름 : " + fish1.getName()); // 변수상자 앞에 public을 붙이는건 좋지 않음, 위험함, 근데 요즘에는 그냥 씀
																	 // 따라서 getName이라는 public 함수상자를 하나 만들어서 retrun name
		System.out.println("fish의 정보 -> 나이 : " + fish1.getAge()); // 나이가 20아래여서 실행 x
		
		
	}

}
