package 도서관;

public class Magazine extends LibraryItem {
	
	public Magazine() {
		
	}
	
	public Magazine(String name, String author) {
		super.title = title;
		super.author = author;
	}
	
	public void read() {
		System.out.println(this.title + "잡지를 읽습니다.");
	}
	
}
