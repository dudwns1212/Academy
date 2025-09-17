
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProjectMain {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in); 
		  int way=10;
	      while(way!=0) {
	         System.out.println("<원하는 검색방법 번호를 입력하세요>(0 입력시 종료됩니다)");
	         System.out.println("1.이름 2.입사년도 3. 부서번호 4. 도시이름 5.통계자료 6. 부서장이름을 통한 부서원검색");
	         try {
	         way = scan.nextInt();
	         } catch (InputMismatchException e) {
	             System.out.println("숫자로 다시 입력해주세요.");
	             scan.nextLine();
	             continue;
	         }
	         switch(way) {
	         case 1:
	            searchByName();
	            break;
	         case 2:
	            searchByYear();
	            break;
	         case 3:
	            searchByDeptId();
	            break;
	         case 4:
	            searchByCity();
	            break;
	         case 5:
	            EmpDAO.printStat();
	            break;
	         case 6:
	            EmpDAO.findEmpByManagerName();
	            break;
	         default:
	            System.out.println("선택지에 없는 번호입니다.");
	            break;
	         }
	      }
	      System.out.println("-프로그램 종료-");
	   }

	//1. 질문 : 사용자의 이름으로 검색기능이 있는가
	private static void searchByName() throws Exception {
		System.out.println("이름: ");
		Scanner scan = new Scanner(System.in);
		ArrayList<Emp> list = new ArrayList();
		String firstName = scan.nextLine();
		list = EmpDAO.findEmpByName(firstName.toLowerCase());
		for(int i=0; i<list.size(); i++) {
			Emp temp = list.get(i);
			System.out.println("사번 :"+temp.empId+", 이름 :"+temp.firstName+" "+temp.lastName+", 이메일 :"+temp.email+", 입사일자 :"+temp.hireDate+", "
								+ "급여:"+temp.salary+", 부서번호 :"+temp.deptId);		
		}
	}
	//
	private static void searchByCity() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("도시 목록");
		System.out.println("Roma, Venice, Tokyo, Hiroshima, Southlake, South San Francisco, South Brunswick, Seattle");
		System.out.println("Toronto, Whitehorse, Beijing, Bombay, Sydney, Singapore, London, Oxford, Stretford");
		System.out.println("Munich, Sao Paulo, Geneva, Bern, Utrecht, Mexico City");
		System.out.print("도시 이름은? : "); 
		String city = scan.nextLine();
		while(city != "") {
			ArrayList<Emp> list = new ArrayList();
			list = EmpDAO.findByCity(city.toLowerCase());
			for(int i=0; i<list.size(); i++) {
				Emp temp = list.get(i);
				System.out.println("사번 :"+temp.empId+", 이름 :"+temp.firstName+" "+temp.lastName+", 이메일 :"+temp.email+", 입사일자 :"+temp.hireDate+", 급여:"+temp.salary+", 부서번호 :"+temp.deptId);		
			}
			System.out.print("입력값 없을 시 종료 : ");
			city = scan.nextLine();
		}
	}

	private static void searchByDeptId() throws Exception{
		Scanner scan = new Scanner(System.in);
		System.out.println("부서번호 입력 : ");
		int dept = scan.nextInt();
		while(dept!=0) {
			ArrayList<Emp> list = new ArrayList<Emp>();
			list = EmpDAO.findEmpByDeptId(dept);
			for(int i=0; i<list.size(); i++) {
				Emp temp = list.get(i);
				System.out.println("사번 :"+temp.empId+", 이름 :"+temp.firstName+" "+temp.lastName
							+", 이메일 :"+temp.email+", 입사일자 :"+temp.hireDate
							+", 급여:"+temp.salary+", 부서번호 :"+temp.deptId);		
			}
			System.out.println("부서번호 입력(0은 종료) : ");
			dept = scan.nextInt();
		}
	}

	private static void searchByYear() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("입사연도 입력(YYYY) : ");
		int year = scan.nextInt();
		while(year!=0) {
			ArrayList<Emp> list = new ArrayList<Emp>();
			list = EmpDAO.findEmpByYear(year);
			for(int i=0; i<list.size(); i++) {
				Emp temp = list.get(i);
				System.out.println("사번 :"+temp.empId+", 이름 :"+temp.firstName+" "+temp.lastName+", 이메일 :"+temp.email+", 입사일자 :"+temp.hireDate+", 급여:"+temp.salary+", 부서번호 :"+temp.deptId);		
			}
			System.out.println("연도 입력(0은 종료) : ");
			year = scan.nextInt();
		}
	}
}
