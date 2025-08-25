package member;

public class Member {
	
	String name;
	int age;
	String number;
	
	public Member(String name, int age, String number) {
		this.name = name;
		this.age = age;
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setName(int age) {
		this.age = age;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
