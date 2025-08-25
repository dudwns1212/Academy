
public class Person {
	
	String name;
	int age;
	String number;
	
	// 코드를 간결화 시키기 위해 생성자로 초기화
	Person(String name, int age, String number){
		this.name = name;
		this.age = age;
		this.number = number;
	}
	
static class Adress {
		
	String city;
	String area;
		
	}
	
	public static void main(String[] args) {
		
		Person youngjun = new Person("GoYoungJun", 25, "010-4041-7802"); // 생성자 초기화로 아래 주석의 긴 코드를 하나로 간결화
   /*	youngjun.name = "GoYoungJun";
		youngjun.age = 25;
		youngjun.number = "010-4041-7802"; 
		본래라면 이렇게 3줄로 직접 값을 입력해야 함 */
		
		Adress adress1 = new Adress();
		adress1.city = "GwangJu";
		adress1.area = "남구 봉선동";
		
		System.out.println(youngjun.name + "의 집은 " + adress1.city + " " +adress1.area + "입니다.");
		
		
		
		
	}
	
}
