 // 1번 고영준
public class Project1 {

	public static void main(String[] args) {
		int i=1;  // 성인 수 입력
		int j=2;  // 어린이 수 입력
		int sum = fee(i,j);  // if문에 사용하기 위해 fee 함수를 변수 sum에 대입
		if(i+j>=5) { // if문을 사용해 인원수가 5인 이상이면 20프로 할인
			sum *= 0.8; // sum = sum*0.8 => sum을 double 자료형으로 만들어야 가능
			System.out.println("단체 할인 20%가 적용되었습니다.");
		}
		
		System.out.println("요금 : " + sum);  // sum값 출력
		
	}
	
	// 인원수를 이용해 총 요금 구하기
	static int fee(int i, int j) { 
		return i*20000 + j*9900;
	}
}
