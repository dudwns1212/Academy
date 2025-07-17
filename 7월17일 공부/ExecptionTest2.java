package myjdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExecptionTest2 {
	public static void main(String[] args) {
		FileReader fr;
		try {
			fr = new FileReader("list.txt");
			int read = fr.read();
			System.out.println(read);
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		finally {
			//예외가 발생되든 안되든 실행되는 구간
			System.out.println("마무리는 무조건");
		}
		
	}
}
