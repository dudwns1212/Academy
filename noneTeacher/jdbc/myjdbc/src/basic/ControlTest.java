package basic;

import java.util.Calendar;

public class ControlTest {
	static int FRIDAY = 6; 
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); 
		int today = cal.get(7);
		
		System.out.println(today);
		if(today==6) {
			System.out.println("불금이네용!!!");
		}
		int today2 = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(today2);
		if(today2 == Calendar.FRIDAY) {
			System.out.println("불금이네용!!!");
		}
		int today3 = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(today2);
		if(today3 == FRIDAY) {
			System.out.println("불금이네용!!!");
		}
	}
}
