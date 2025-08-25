
public class Test1 {

	public static void main(String[] args) {
		
		// 물고기 만들기
		Fish fish1 = new Fish();
		fish1.name = "물고기1";
		
		//바다 만들기
		Sea sea1 = new Sea();
		sea1.name = "태평양";
		sea1.fish = fish1;
		
// Sea라는 변수묶음(틀)에서 만들어진 변수상자 sea1이 Fish라는 틀에서 만들어진 fish1을 가리킴, 따라서 sea1->fish1->name 즉 sea1을 통해 fish1 안의 변수인 물고기1을 출력
		System.out.println("바다 안에 들어있는 물고기의 이름은? : " + sea1.fish.name);

	}

}
