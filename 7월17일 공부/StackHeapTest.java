package basic;

public class StackHeapTest {
	public static void main(String[] args) {
		int count = 500; //기본형 4bytes
		Product product; //참조형
		product = new Product(); // -> Heap 영역에 객체 생성
		product.maker = "Samsung";
		change(product);
		System.out.println(product.maker);
		
	}

	private static void change(Product pro) {
		pro.maker = "Apple";
		
	}
}
