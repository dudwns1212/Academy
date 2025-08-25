package 책과만화책을판매하는서점구현;

public class Book implements IBook {
	
	String title;
	String author;
	String publishDate;
	
	public Book() {
		
	}
	
	public Book(String title, String author, String publishDate) {
		this.title = title;
		this.author = author;
		this.publishDate = publishDate;
	}
	
	public void read() {
		System.out.println("책을 읽습니다.");
	}
	
}
