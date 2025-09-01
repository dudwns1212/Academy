//전달받은 문자열이 회문(앞으로나 뒤로나 동일한 문자열) 문자열인지를 체크하는 메서드를 완성하시오.
//제출: heee@lx.co.kr

import java.util.Scanner;

public class hihi {
	public static void main(String[] args) {
		System.out.println("문자열을 입력하세요");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		StringBuffer sb = new StringBuffer(input);
		
		String newInput = sb.reverse().toString();
		
		System.out.println(newInput);
		 
		if(input.equals(newInput)) {
			System.out.println("문자열이 회문 입니다.");
		} else {
			System.out.println("문자열이 회문이 아닙니다.");
		}
		
	}
}
