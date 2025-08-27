package basic;

public class ProductTest {
	public static void main(String[] args) {
		Product product = makeProduct("S25:Samsung:1500000");
		System.out.println(product);
	}
	// 문자열을 전달받아서 제품정보를 리턴함 (객체로!)
	private static Product makeProduct(String productInfo) {
		Product product = new Product();
		String[] info = productInfo.split(":");
		product.model = info[0];
		product.maker = info[1];
		product.price = Integer.parseInt(info[2]);
		return product;
	}
	
}

class Product{
	String model;
	String maker;
	int price;
	@Override
	public String toString() {
		return "ProductTest [model=" + model + ", maker=" + maker + ", price=" + price+ "]";
	}
}