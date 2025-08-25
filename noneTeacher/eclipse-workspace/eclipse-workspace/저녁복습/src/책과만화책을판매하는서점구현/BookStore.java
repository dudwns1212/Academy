package 책과만화책을판매하는서점구현;

import java.util.ArrayList;
import java.util.HashMap;

public class BookStore {
	
	public int totalSales = 0;
	
	HashMap<String,ArrayList<IBook>>bookMap = new HashMap<String,ArrayList<IBook>>();
	
	public IBook sell(String type, int price) {
		
		totalSales += price;
		
		if(type.equals("book")) {
			System.out.println("책을 고르셨습니다.");
			System.out.println("가격은 " + price + "원 입니다.");
			
			IBook output = bookMap.get("book").removeFirst();
			
			return output;
			
		} else if(type.equals("comic")) {
			System.out.println("만화책을 고르셨습니다.");
			System.out.println("가격은 " + price + "원 입니다.");
			
			IBook output = bookMap.get("comic").removeFirst();
			
			return output;
			
		} else {
			System.out.println("타입을 잘못고르셨습니다.");
			
			IBook output = null;
			
			return output;
		}
		
		
		
		
	}
	
}
