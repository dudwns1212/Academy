package 도서관;

public class maintest {
	
	public static void main(String[] args) {
		
		Library library = new Library();
		
		library.books.add(new Book("어린왕자", "생텍쥐페리"));
		library.books.add(new Book("돈키호테", "세르반테스"));
		library.books.add(new Book("해리포터", "로우링"));
		
		library.magazines.add(new Magazine("잡지1","저자1"));
		library.magazines.add(new Magazine("잡지2","저자2"));
		library.magazines.add(new Magazine("잡지3","저자3"));
		library.magazines.add(new Magazine("잡지4","저자4"));
		library.magazines.add(new Magazine("잡지5","저자5"));
		
		
		library.borrow("book", "어린왕자", "생텍쥐페리");
		library.borrow("magazine", "잡지3", "저자3");
		library.borrow("magazine", "잡지5", "저자5");
		library.borrow("book", "해리포터", "로우링");
		
		for(int i=0;i<library.dateToBorrowedItems.size();i++) {
			System.out.println(library.dateToBorrowedItems.get(library.dS).get(i).title);
		}
		
		System.out.println("총 대출 수 : " + library.Count);
		
	}
	
}
