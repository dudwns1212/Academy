package 저녁복습;

public class 쇼핑리스트출력하기 {
	public static void main(String[] args) {
		String 쇼핑1 = "달걀1박스";
		String 쇼핑2 = "라면2묶음";
		String 쇼핑3 = "참치캔6캔";
		int price1 = 1115000;
		int price2 = 300;
		int price3 = 14000;
		
		System.out.printf("품명: %-10s 가격: %8d\n", 쇼핑1, price1);
		System.out.printf("품명: %-10s 가격: %8d\n", 쇼핑2, price2);
		System.out.printf("품명: %-10s 가격: %8d\n", 쇼핑3, price3);
		
	}
}
