package 도서관;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Library {
	
	public int Count = 0;
	
	String dS;
	
	ArrayList<LibraryItem>books = new ArrayList<LibraryItem>();
	ArrayList<LibraryItem>magazines = new ArrayList<LibraryItem>();
	HashMap<String,ArrayList<LibraryItem>> dateToBorrowedItems = new HashMap<String,ArrayList<LibraryItem>>();
	HashMap<String, Integer> dateToBorrowCount = new HashMap<String, Integer>();
	
	public void borrow(String type, String title, String author) {
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		dS = format.format(date);
		
		
		if(!dateToBorrowedItems.containsKey(dS)) {
			dateToBorrowedItems.put(dS, new ArrayList<>());
		}
		
		LibraryItem item = null;
	       if (type.equals("book")) {
	           item = new Book(title, author);
	           System.out.println("책이 대출되었습니다.");
	       } else if (type.equals("magazine")) {
	           item = new Magazine(title, author);
	           System.out.println("잡지가 대출되었습니다.");
	       } else {
            System.out.println("타입이 잘못되었습니다.");
           return;
	       }
	       
	     
	       dateToBorrowedItems.get(dS).add(item);
	     
	       Count++;
		
		
	}
	
}
