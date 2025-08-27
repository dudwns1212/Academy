package basic;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex01 {
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int random = (int) (Math.random() * 100) + 1;
		int input;
		int count=0;
		ArrayList inputs = new ArrayList();
		System.out.print("숫자를 입력하세요 : ");
		
		while(true) {
			input = scan.nextInt();
			System.out.println(input);
			
			
			if(input>random && input<=100) {
				count++;
				System.out.println("아래");
				inputs.add(input);
	
			} else if(input<random && input>=0) {
				count++;
				System.out.println("위");
				inputs.add(input);

			} else if(input == random) {
				count++;
				System.out.println(count + "번 만에 맞추셨습니다.");
				inputs.add(input);
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
				System.out.println("숫자를 입력하세요 : ");
				continue;
			}
			System.out.println("숫자를 입력하세요 : ");
			
			
		}
		
		for(int i=0;i<inputs.size();i++) {
			System.out.println("입력한 숫자 : " + inputs.get(i));
		}
		
	}
	
	
	
}
