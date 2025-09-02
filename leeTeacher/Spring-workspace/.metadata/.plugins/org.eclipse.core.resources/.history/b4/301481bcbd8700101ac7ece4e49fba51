
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class EmpDAO {
	public static ArrayList<Emp> findEmpByYear(int year) throws Exception {
		ArrayList<Emp> result = new ArrayList<Emp>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = connection.createStatement();
		String sql = "select employee_id, department_id, first_name, last_name, DATE_FORMAT(hire_date, '%Y-%m-%d') hd, email, salary"
				+ " from employees where year(hire_date) ="+year;
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Emp tempEmp = new Emp();
			tempEmp.empId=rs.getInt("employee_id");
			tempEmp.deptId=rs.getInt("department_id");
			tempEmp.firstName=rs.getString("first_name");
			tempEmp.lastName=rs.getString("last_name");
			tempEmp.hireDate=rs.getString("hd");
			tempEmp.salary=rs.getInt("salary");
			tempEmp.email=rs.getString("email");
			result.add(tempEmp);
			}
		connection.close();
		return result;
	}
	public static ArrayList<Emp> findEmpByDeptId(int deptId) throws Exception {
		ArrayList<Emp> result = new ArrayList<Emp>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = connection.createStatement();//
		String sql = "select employee_id, department_id, first_name, Last_name, DATE_FORMAT(hire_date, '%Y-%m-%d') hd, email, salary "
				+ "from employees "
				+ "where department_id = " + deptId;
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Emp tempEmp = new Emp();
			tempEmp.empId=rs.getInt("employee_id");
			tempEmp.deptId=rs.getInt("department_id");
			tempEmp.firstName=rs.getString("first_name");
			tempEmp.lastName=rs.getString("last_name");
			tempEmp.hireDate=rs.getString("hd");
			tempEmp.salary=rs.getInt("salary");
			tempEmp.email=rs.getString("email");
			result.add(tempEmp);
		}
		connection.close();
		return result;
	}
	public static void printStat() throws Exception {
		Emp result = new Emp();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection 이라는 인터페이스다 //메서드다
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = connection.createStatement();
		String sql = "select d.department_name dname, round(avg(salary), -2) avs, max(salary) maxs, min(salary) mins "
				+ "from employees e join departments d "
				+ "on e.department_id = d.department_id  "
				+ "group by  d.department_name, e.department_id "
				+ "order by e.department_id  "  ;
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			result.salary = (int)rs.getInt("avs");
			result.departmentName = rs.getString("dname");
			int maxs=(int)rs.getInt("maxs");
			int mins=(int)rs.getInt("mins");
			System.out.println("부서명 : "+result.departmentName+", 평균월급 : "+result.salary + "$" +", 최대급여 : "+maxs + "$" +", 최소급여 : "+ mins + "$");
			
		}
		connection.close();
	}
	public static void findEmpByManagerName() throws Exception {
		System.out.println("부서장 목록");
		System.out.println("Steven King, Alexander Hunold, Nancy Greenberg, Den Raphaely, Adam Fripp, John Russell");
		System.out.println("Jennifer Whalen, Michael Hartstein, Susan Mavris, Hermann Baer, Shelley Higgins");
		System.out.print("부서장 이름(이름+성으로 입력): ");
		Scanner scan = new Scanner(System.in);
		String departname = scan.nextLine();
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = connection.createStatement();
		String sql = "select EMPLOYEE_ID, DEPARTMENT_ID, FIRST_NAME, LAST_NAME, salary, DATE_FORMAT(hire_date, '%Y-%m-%d'), EMAIL "
				+ " from EMPLOYEES where DEPARTMENT_ID = "
				+ "(select DepartMent_id from DEPARTMENTS where Manager_id =  "
				+ "(select Employee_id from EMPLOYEES"
				+ "	where lower(concat(First_name,LAST_NAME)) = '" +departname.toLowerCase()+"'))" ;
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println("사번 :"+rs.getInt(1)+ ", 이름 :"+rs.getString(3)+ " " + rs.getString(4)+", 이메일 :" + rs.getString(7) + ", 입사일자 :" + rs.getString(6)+ ", 급여 :"+rs.getInt(5)+", 부서번호 :"+rs.getInt(2) );
		}
		connection.close();
	}
	public static ArrayList<Emp> findByCity(String city) throws Exception{
		ArrayList<Emp> result = new ArrayList<>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = connection.createStatement();
		String sql = "select employee_id, department_id, first_name, last_name, DATE_FORMAT(hire_date, '%Y-%m-%d') hd, email, salary, email from EMPLOYEES where DEPARTMENT_ID "
				+ "in (select DEPARTMENT_ID from DEPARTMENTS where LOCATION_ID = "
				+ "(select LOCATION_ID from LOCATIONS where lower(city) ='"+city+"'))";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			Emp emp = new Emp();
			emp.empId = rs.getInt("employee_id");
			emp.deptId = rs.getInt("department_id");
			emp.firstName = rs.getString("first_name");
			emp.lastName = rs.getString("last_name");
			emp.hireDate = rs.getString("hd");
			emp.salary = rs.getInt("salary");
			emp.email = rs.getString("email");
			result.add(emp);
		}
		connection.close();
		return result;
	}
	public static ArrayList<Emp> findEmpByName(String firstName) throws Exception {
		ArrayList<Emp> result = new ArrayList();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = connection.createStatement();
		
		// 이름을 입력하고 그 이름에 해당하는 사원의 정보를 불러오는 sql 쿼리 문장을 넣어줌
		String sql = "select employee_id, department_id, first_name, last_name, DATE_FORMAT(hire_date, '%Y-%m-%d') hd, email, salary, email "
				      + "from employees "
				      + "where lower(first_name) ='" + firstName.toLowerCase()+"'";   
		ResultSet rs = stmt.executeQuery(sql);  // 
		while(rs.next()) {
			Emp tempEmp = new Emp();
			tempEmp.empId=rs.getInt("employee_id");
			tempEmp.deptId=rs.getInt("department_id");
			tempEmp.firstName=rs.getString("first_name");
			tempEmp.lastName=rs.getString("last_name");
			tempEmp.hireDate=rs.getString("hd");
			tempEmp.salary=rs.getInt("salary");
			tempEmp.email=rs.getString("email");
			result.add(tempEmp);
		}
		
		connection.close();
		return result;
	}
}
