package basic;

public class ControlTest2 {
	public static void main(String[] args) {
		// 1부터 얼마까지 누적해야 백만을 초과할까? 1+2+3....
		// 변수? 로직? 제어문? ...
		int count = 0;
		int sum = 0;
		while(sum<=1000000) {
			count++;
			sum = sum + count;
		}
		
		System.out.printf("1부터 %d까지 누적하면 %d가 되고 백만을 넘습니다.", count, sum);
		
		
		
	}
	
	public void makeNumber() {
		
	}

}

