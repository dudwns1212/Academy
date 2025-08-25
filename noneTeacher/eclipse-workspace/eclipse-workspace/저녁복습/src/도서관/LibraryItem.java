package 도서관;

public class LibraryItem {
	
	public String title;
	public String author;
	
	public LibraryItem() {
		
	}
	
	public LibraryItem(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public void read() {
		System.out.println(this.title + "책을 읽습니다.");
	}
	
}
