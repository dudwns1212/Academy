package 책과만화책을판매하는서점구현;

import java.util.ArrayList;

public class maintest1 {
	
	public static void main(String[] args) {
		
		
		BookStore bookstore = new BookStore();
		// 그냥 책들 리스트
		ArrayList<IBook> books = new ArrayList<IBook>();
		books.add(new Book());
		books.add(new Book());
		books.add(new Book());
		books.add(new Book());
		books.add(new Book());
		
		// 만화책들 리스트
		ArrayList<IBook> comicbooks = new ArrayList<IBook>();
		comicbooks.add(new ComicBook());
		comicbooks.add(new ComicBook());
		comicbooks.add(new ComicBook());
		comicbooks.add(new ComicBook());
		comicbooks.add(new ComicBook());
		
		// 해시맵리스트에 책과 만화를 키로 하는 배열들 넣어주기
		bookstore.bookMap.put("book", books);
		bookstore.bookMap.put("comic", comicbooks);
		
		bookstore.sell("book", 10000);
		bookstore.sell("comic", 15000);
		bookstore.sell("book", 7000);
		bookstore.sell("book", 11000);
		bookstore.sell("comic", 20000);
		bookstore.sell("comic", 25000);
		
		System.out.println("서점의 최종 판매액 : " + bookstore.totalSales);
		
		
	}
	
}
