package 아침복습2;
import com.lx.sea.Sea;

import java.util.ArrayList;

import com.lx.sea.Fish;

// Sea , Fish를 만들고 생성자를 통해서 만들때마다 카운트를 하나씩 올리게
public class Test2 {
	
	public static void main(String[] args) {
		
		Sea sea1 = new Sea();
		Sea sea2 = new Sea();
		sea1.name = "바다1";
		sea2.name = "바다2";
		
		ArrayList <Sea> seas = new ArrayList <Sea>();
		
		Fish fish1 = new Fish();
		Fish fish2 = new Fish();
		Fish fish3 = new Fish();
		Fish fish4 = new Fish();
		Fish fish5 = new Fish("물고기5");
		Fish fish6 = new Fish("물고기6");
		Fish fish7 = new Fish("물고기7");
		
		fish1.name = "물고기1";
		fish2.name = "물고기2";
		fish3.name = "물고기3";
		fish4.name = "물고기4";
		
		seas.add(fish1);
		seas.add(fish2);
		seas.add(fish3);
		seas.add(fish4);
		
		System.out.println(sea1.name + "에 있는 물고기의 수 : " + seas.size());  // 배열을 통해 물고기의 수 출력 -> 새로 생성될때마다 하나씩 배열에 추가해줘야됨
		System.out.println(sea1.name + "에 있는 물고기의 수 : " + Fish.count); // 생성자를 통한 물고기의 수 출력 -> 새로 생성되면 자동으로 생성자가 실행
		
	}
	
}
