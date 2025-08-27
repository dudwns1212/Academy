package basic;

public class StingTest {
	public static void main(String[] args) {
		String str = "Hello";
		String str2 = "Hello";
		System.out.println(str == str2);
		String str3 = new String("Hello");
		System.out.println(str == str3);
		System.out.println(str.equals(str3));
		str = str.replace('H', 'h'); // 새로 생성된 문자열이다. String 객체는 immutable 하다.
		System.out.println(str);
		str = str + "haha"; // 기존의 str내부의 문자열이 변경되는 것이 아니라 새로 문자열이 생성되어 할당됨 
		String product = "S25:Samsung:1500000";
		String[] productInfo = product.split(":");
		
		
		
	}
}
