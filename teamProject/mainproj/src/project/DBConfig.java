package project;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DBConfig {

		public static String set(String key) {
		
		// key를 넣으면 value를 내보낼 수 있는 Properties 객체를 만든거임
		Properties props = new Properties();
		String propertiesFile =  "db-info.properties";
		
		// 메모장을 읽고 로드하는데 안되면 e 객체가 가진 메시지 내보내기

			try {
				props.load(new FileReader(propertiesFile));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
	
		return props.getProperty(key);
		}
}

