package myjdbc;

import java.util.Scanner;

public class WhileTest {
	public static void main(String[] args) throws Exception {
		//입력한 문자에 대한 아스키값을 출력함
		//q나 Q를 입력하면 종료
		Scanner scan = new Scanner(System.in);
		System.out.println("문자입력:");
		String input = scan.nextLine();
		char first = input.charAt(0);
		if(input.length()==0) throw new Exception("아무것도 입력하지 않았어요");
		while(first != 'q') {
			System.out.println((int)first);
			input = scan.nextLine();
			first = input.charAt(0);
		}
		
		
	}
}
