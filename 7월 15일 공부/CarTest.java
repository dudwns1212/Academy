package Ex03;

public class CarTest {
	public static void main(String[] args) {
		// Car 객체 생성
		Car hudson = new Car();
		Car carrera = new Car();
		Car mater = new Car();
		
		hudson.setName("Hudson");
		carrera.setName("Carrera");
		mater.setName("Mater");
		
		hudson.setSpeed(300);
		mater.setSpeed(80);
		carrera.setSpeed(200);
		
		hudson.printCar();
		mater.printCar();
		carrera.printCar();
	}
}

class Car {
	
	String name;
	int speed;
	
	void setName(String name) {
		this.name=name;
	}
	void setSpeed(int speed) {
		this.speed=speed;
	}
	String getName() {
		return name;
	}
	int getSpeed() {
		return speed;
	}
	
	void printCar() {
		System.out.println("차 이름 : " + name + "\t차 스피드 : " + speed);
	}
	
}
