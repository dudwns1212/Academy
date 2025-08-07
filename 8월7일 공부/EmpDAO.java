package myjsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



// 메서드를 실행하기 위한 변수의 정의 및 사용하기 위해 get,set 메서드 정의하는 클래스 
public class EmpDAO {
	
	public static List<String> getJobList() throws Exception {
		List<String> list = new ArrayList<String>();
		
		Connection connection = getConnetion();
		
		String sql = "select distinct job_id from employees";
		PreparedStatement psmt = connection.prepareStatement(sql);
		ResultSet rs = psmt. executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1));
			list.add(rs.getString(1));
		}
		// list, result랑 같은거임 다른방법도 있다~ 
		String[] result = new String[list.size()];
		for(int i=0;i<list.size();i++) {
			result[i] = list.get(i);
		}
		connection.close();
		return list;
	}
	private static Connection getConnetion() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envContext.lookup("jdbc/mydb");
		Connection connection = dataSource.getConnection();
		return connection;
	}
	public static List<EmployeeTO> getEmpList(String jobId) throws Exception {
		List<EmployeeTO> list2 = new ArrayList<EmployeeTO>();
		Connection connection = getConnetion();
		String sql = "select * from employees where job_id = ?";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, jobId);
		
		ResultSet rs = psmt. executeQuery();
		while(rs.next()) {
			EmployeeTO emp = new EmployeeTO();
			emp.employeeId = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.departmentId = rs.getString("department_id");
			emp.salary = rs.getInt("salary");
			list2.add(emp);
		}
		connection.close();
		return list2;
	}
	
	public static List<EmployeeTO> getEmpListByEmpId(String ok) throws Exception {
		List<EmployeeTO> list2 = new ArrayList<EmployeeTO>();
		Connection connection = getConnetion();
		String sql = "select * from employees where employee_id = ?";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, ok);
		
		ResultSet rs = psmt. executeQuery();
		while(rs.next()) {
			EmployeeTO emp = new EmployeeTO();
			emp.employeeId = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.departmentId = rs.getString("department_id");
			emp.salary = rs.getInt("salary");
			list2.add(emp);
		}
		connection.close();
		return list2;
	}
	
	public static List<EmployeeTO> getEmpListByDpId(String ok) throws Exception {
		List<EmployeeTO> list2 = new ArrayList<EmployeeTO>();
		Connection connection = getConnetion();
		String sql = "select * from employees where department_id = ?";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, ok);
		
		ResultSet rs = psmt. executeQuery();
		while(rs.next()) {
			EmployeeTO emp = new EmployeeTO();
			emp.employeeId = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.departmentId = rs.getString("department_id");
			emp.salary = rs.getInt("salary");
			list2.add(emp);
		}
		connection.close();
		return list2;
	}
	
	public static List<EmployeeTO> getEmpListByName(String ok) throws Exception {
		List<EmployeeTO> list2 = new ArrayList<EmployeeTO>();
		Connection connection = getConnetion();
		String sql = "select * from employees where first_name = ?";
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1, ok);
		
		ResultSet rs = psmt. executeQuery();
		while(rs.next()) {
			EmployeeTO emp = new EmployeeTO();
			emp.employeeId = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.departmentId = rs.getString("department_id");
			emp.salary = rs.getInt("salary");
			list2.add(emp);
		}
		connection.close();
		return list2;
	}
	
	public static List<EmployeeTO> getEmpListALL() throws Exception {
		List<EmployeeTO> list2 = new ArrayList<EmployeeTO>();
		Connection connection = getConnetion();
		String sql = "select * from employees";
		PreparedStatement psmt = connection.prepareStatement(sql);
		
		ResultSet rs = psmt. executeQuery();
		while(rs.next()) {
			EmployeeTO emp = new EmployeeTO();
			emp.employeeId = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.departmentId = rs.getString("department_id");
			emp.salary = rs.getInt("salary");
			list2.add(emp);
		}
		connection.close();
		return list2;
	}
	
	

	
}
