package myjsp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
// 메서드를 사용하기 위해 메서드를 생성한 클래스
public class UserIO {
	// 사용자의 정보를 전달 받아서  파일에 저장한다.
	public void addUser(User user, String fileName) throws Exception {
		PrintWriter out = new PrintWriter(new FileWriter(fileName, true)); //append
		String str = user.getLastName() + "|" + user.getFirstName() + "|" + user.getEmail();
		out.println(str);
		out.close();//
		
		}
}
