package project;

public class DBMain {
	public static void main(String[] args) {		
		MenuController.setContext();
		MenuController.run();
		// db메서드에서 인트값만 받는 애들은 스트링넣으면 오류뜨니까 trycatch로 바꿔야 하나
	}
}
