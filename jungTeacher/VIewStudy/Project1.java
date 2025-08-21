package project;

import java.util.List;
import java.util.Scanner;


public class Db_main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Db_method db = new Db_method();
		
		while(true) {
			System.out.println("==기능을 선택하세요==");
			System.out.println("1. 직원이름으로 직원정보 검색하기");
			System.out.println("2. 입사년도로 직원정보 검색하기");
			System.out.println("3. 부서번호로 직원정보 검색하기");
			System.out.println("4. 직무로 직원정보 검색하기");
			System.out.println("5. 도시이름으로 직원정보 검색하기");
			System.out.println("6. 통계자료 출력하기");
			System.out.println("7. 부서장 성으로 부서원 정보 검색하기");
			System.out.println("8. 나라이름으로 직원정보 검색하기");
			System.out.println("0. 프로그램 종료하기");
			System.out.println("선택 >>");
			int number = scan.nextInt();
			
			switch (number) {
				case 1 -> { 
						System.out.print("직원 이름을 입력하세요 : ");
						scan.nextLine();
						String fullName = scan.nextLine();
						db.method1(fullName);
				}					
				case 2 -> {
						System.out.print("입사년도를 입력하세요 : ");
						int year = scan.nextInt();
						scan.nextLine();
						db.method2(year);
				}
				case 3 -> {
						System.out.println("부서번호를 입력하세요 : [ex100]");
						int dpId = scan.nextInt();
						scan.nextLine();
						db.method3(dpId);
				}
				case 4 -> {
						System.out.print("직무를 입력하세요 : ");
						scan.nextLine();
						String job = scan.nextLine();
						db.method4(job);
				}
				case 5 -> {
					System.out.print("도시명을 입력하세요 : ");
					scan.nextLine();
					String cityName = scan.nextLine();
					db.method5(cityName);
				}
				case 6 -> {
					System.out.print("통계자료를 출력합니다");
					db.method6();
				}
				case 7 -> {
					System.out.print("부서장 성을 입력하세요 : ");
					scan.nextLine();
					String managerId = scan.nextLine();
					db.method7(managerId);
				}
				case 8 -> {
					System.out.print("나라이름을 입력하세요 : ");
					scan.nextLine();
					String countryName = scan.nextLine();
					db.method8(countryName);
				}
				case 0 -> { 
					db.close();
					System.out.println("프로그램 종료");
						return;
			}
			default -> System.out.println("잘못된 입력입니다.");
			
			}
			
			
		}
	}
}




package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import myjdbc.Emp;



public class Db_method { 
	public Connection conn = null;
	DBConfig dbc;
	
	public Db_method() throws Exception { // 생성자로 생성마다 자동 실행
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
			
		} catch (SQLException e) {
				System.out.println("DB 연결 실패: " + e.getMessage());

		}
	}
	// 메서드로 sql이랑 값들 받아서 EmployInfo리스트를 만들어주는 함수		
	public List<EmployInfo> executeQuery(String sql, Object... params) {
		List<EmployInfo> info = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
				}
				ResultSet rs = stmt.executeQuery();
		
				while(rs.next()) {
					EmployInfo emp = new EmployInfo();
					emp.employ_id = rs.getInt("employee_id");
					emp.last_name = rs.getString("last_name");
					emp.salary = rs.getInt("salary");
					info.add(emp);
			}
		} catch (SQLException e) {
				 System.out.println("쿼리 실행 오류: " + e.getMessage());
		}
		return info;
		
		}
	//기능들
		public void method1(String fullName) { // 직원이름
		List<EmployInfo> result = executeQuery(dbc.set("getEmpInfoByEmpNameSql"), fullName);
		System.out.println("==이름이 " + fullName + "인 직원정보==");
		for(EmployInfo info : result) {
			System.out.println(info);
			}
		}	
		public void method2(int year) { // 입사년도 작동 ㅇ
		List<EmployInfo> result = executeQuery(dbc.set("getEmpInfoByHireyearSql"), year);
		System.out.println("==" + year + "년 입사 직원정보==");
		for(EmployInfo info : result) {
			System.out.println(info);
			}
		}
		public void method3(int dpId) { // 부서번호 작동 o
			List<EmployInfo> result = executeQuery(dbc.set("getEmpInfoByDeptIdSql"), dpId);
			System.out.println("==부서번호가 " + dpId + "인 직원정보==");
			for(EmployInfo info : result) {
				System.out.println(info);
			}
		}
		public void method4(String job) { // 직무 작동 ㅇ
			List<EmployInfo> result = executeQuery(dbc.set("getEmpInfoByJobIdSql"), job);
			System.out.println("==" + job + "직군인 직원정보==");
			for(EmployInfo info : result) {
				System.out.println(info);
			}
		}	
		public void method5(String cityName) { // 도시이름 작동 o
			List<EmployInfo> result = executeQuery(dbc.set("getEmpInfoByCityNameSelect"), cityName);
			System.out.println("==" + cityName + "에서 근무하는 직원정보==");
			for(EmployInfo info : result) {
				System.out.println(info);
			}
		}
		public void method6() {
			try (PreparedStatement stmt = conn.prepareStatement(dbc.set("summry")); ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {
					int count = rs.getInt("count(*)");
					double avg = rs.getDouble("avg(salary)");
					int max = rs.getInt("max(salary)");
					int min = rs.getInt("min(salary)");

					System.out.println("총 직원 수: " + count);
					System.out.printf("평균 급여: %.2f\n", avg);
					System.out.println("최고 급여: " + max);
					System.out.println("최저 급여: " + min);
				}
			} catch (SQLException e) {
				System.out.println("통계 쿼리 실행 오류: " + e.getMessage());
			}
		}
		public void method7(String managerId) { 
			List<EmployInfo> result = executeQuery(dbc.set("getEmpInfoByManagerId"), managerId);
			System.out.println("==매니저 성이 " + managerId + "인 부서원정보==");
			for(EmployInfo info : result) {
				System.out.println(info);
			}
		}
		public void method8(String country_name) { // 나라이름
			List<EmployInfo> result = executeQuery(dbc.set("getEmpInfoByCountryName"), country_name);
			System.out.println("==" + country_name + "에서 근무하는 직원정보==");
			for(EmployInfo info : result) {
				System.out.println(info);
			}
		}
		
		public void close() {
			try {
				if (conn != null && !conn.isClosed()) {
						conn.close();
						System.out.println("DB 연결 해제");
				}
			} catch (SQLException e) {
					e.printStackTrace();
			}
		}

	
}
	



package project;

public class EmployInfo {
	public int employ_id;
	public String last_name;
	public int salary;
	
	public String toString() {
		return "Emp [employ_id=" + employ_id + ", last_name=" + last_name + ", salary=" + salary + "]";
	}
}



package project;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class DBConfig {

		public static String set(String key) {
		
		// key를 넣으면 value를 내보낼 수 있는 Properties 객체를 만든거임
		Properties props = new Properties();
		
		// 메모장을 읽고 로드하는데 안되면 e 객체가 가진 메시지 내보내기
		try {
			props.load(new FileReader("db-info.properties"));
		} catch (IOException e) {
			System.out.println(e.getMessage());	
		}
		return props.getProperty(key);
		}
}



driverClassName=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/newhr
userName=root
passWord=rootroot

#
getEmpInfoByEmpNameSql=select * from employees where lower(concat(last_name, first_name)) = lower(Replace(?,' ',''))
getEmpInfoByHireyearSql=select * FROM employees where year(hire_date) = ?
getEmpInfoByJobIdSql=select * from employees where job_id = ?
getEmpInfoByDeptIdSql=select * from employees where department_id = ?

getEmpInfoByCityNameSelect=select * from employees e where e.department_id in (select d.department_id from departments d where d.location_id in (select l.location_id from locations l where city = ?))
getEmpInfoByManagerId=select e.*, m.last_name from employees e left join employees m on e.manager_id = m.employee_id where m.last_name = ?
getEmpInfoByCountryName=select * from employees e where e.department_id in (select d.department_id from departments d where d.location_id in(select l.location_id from locations l where l.country_id in (select c.country_id from countries c where country_name = ?)))
summry=select count(*), avg(salary), max(salary), min(salary) from employees 

