import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Library {
	ArrayList<Member>members = new ArrayList<Member>();
	ArrayList<Book>books = new ArrayList<Book>();
	ArrayList loans = new ArrayList<>();
	Library library;
	Book book;
	HashMap<String,ArrayList<Book>>AllOfLibrary = new HashMap<String,ArrayList<Book>>();

	public void loanDate(Member member, Book book) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
		String loanDate = format.format(date);
		book.isBorrowed = true;
		
		
		System.out.println(member.name + "님이 " + book.title + " 책을 " + loanDate + "에 대출하였습니다.");
		books.add(book);
		
	}
	
	public void returnDate(Member member, Book book) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("YYYY-mm-DD");
		String returnDate = format.format(date);
		book.isBorrowed = false;
		
		books.remove(book);
		System.out.println(member.name + "님이 " + book.title + " 책을 " + returnDate + "에 반납하였습니다.");
		
	}
}
