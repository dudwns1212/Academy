package basic;

public class InheritanceTest {
	public static void main(String[] args) {
		Shape shape = new Rectangle();
		shape.print();
	}
	
}


interface Shape {
	public abstract void print(); 
}

class Rectangle implements Shape{

	public void print() {
		
	}
}
