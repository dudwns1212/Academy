/*입력한 배열의 합을 구하는 프로그램을 작성하시오.
 - 입력 : 4 9 3 50 => 문자열로 입력됨
 - 출력 : 64*/

import java.util.ArrayList;
import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		// 값을 직접 입력해서 뽑아보기
		Scanner scan = new Scanner(System.in);	//값을 입력받기 위해 scan
		ArrayList<String> al = new ArrayList(); //입력받은 값의 길이를 모르기에 arraylist 사용
		String input = null;					//input은 string
		Boolean aa = true;						//while문을 끝내려면 aa=false;
		int sum = 0; 							//마지막에 출력할 모든 값을 더할 sum
		
		System.out.println("문자열 배열을 생성합니다. 그만하시려면 'stop'을 입력해주세요");
		
		while (aa) {
			System.out.print("숫자만 입력하세요 :");
			input = scan.nextLine();
			if (input.equals("stop")) {
				System.out.println("문자열 배열이 입력되었습니다 : " + al);
				aa = false;
			} else {
				al.add(input);
			}
		}

		for (String a : al) {
			sum += Integer.parseInt(a);
		}
		
		System.out.println("숫자들의 총 합 : " + sum);
	}

}
/*
		값을 직접 입력하지 않고 그냥 정해진 값에 split만

		String input = "4 9 3 50";
		String[] in = input.split(" ");
		int sum = 0;
		for(int i = 0;i<in.length;i++) {
			int a = Integer.parseInt(in[i]);
			sum += a;
		}
		System.out.println(sum);
	}
*/