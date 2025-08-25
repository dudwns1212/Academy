//로또추첨 코드 만들기
package 아침복습;

import java.util.*;

public class Lotto {
	public static void main(String[] args) {
		ArrayList Lotto = new ArrayList();
		for (int i=1;i<=45;i++) {
			Lotto.add(i);
		}
		Collections.shuffle(Lotto);
		
		List myBirth = Lotto.subList(0, 6);
		
		if(myBirth.contains(12) && myBirth.contains(7)) {
		System.out.println(myBirth);
		}else {
		System.out.println("포함되지 않았습니다.");
		}
	}
		
}

