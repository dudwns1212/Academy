package myjsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ReDAO {
	private static Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envContext.lookup("jdbc/mydb");
		Connection connection = dataSource.getConnection();
		return connection;
	}
	
	public static List<String> EmpJobIdList (String jobId) throws Exception {
		List<String> list = new ArrayList<String>();
		Connection connection = getConnection();
		String sql = "select distinct job_id from employees";
		PreparedStatement psmt = getConnection().prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			list.add(rs.getString(1));
		}
		connection.close();
		return list;
	}
	
	public static List<EmployeeTO> EmpListByName (String O) throws Exception {
		List<EmployeeTO> list = new ArrayList<EmployeeTO>();
		Connection connection = getConnection();
		String sql = "select * from employees where first_name = ?";
		PreparedStatement psmt = getConnection().prepareStatement(sql);
		psmt.setString(1, O);
		
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			EmployeeTO emp = new EmployeeTO();
			emp.departmentId = rs.getString("department_id");
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.salary = rs.getInt("salary");
			
			list.add(emp);
		}
		connection.close();
		return list;
	}
	
	public static List<EmployeeTO> EmpListByEmpId (String O) throws Exception {
		List<EmployeeTO> list = new ArrayList<EmployeeTO>();
		Connection connection = getConnection();
		String sql = "select * from employees where employee_id = ?";
		PreparedStatement psmt = getConnection().prepareStatement(sql);
		psmt.setString(1, O);
		
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			EmployeeTO emp = new EmployeeTO();
			emp.departmentId = rs.getString("department_id");
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.salary = rs.getInt("salary");
			
			list.add(emp);
		}
		connection.close();
		return list;
	}
	
	public static List<EmployeeTO> EmpListByDeptId (String O) throws Exception {
		List<EmployeeTO> list = new ArrayList<EmployeeTO>();
		Connection connection = getConnection();
		String sql = "select * from employees where department_id = ?";
		PreparedStatement psmt = getConnection().prepareStatement(sql);
		psmt.setString(1, O);
		
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			EmployeeTO emp = new EmployeeTO();
			emp.departmentId = rs.getString("department_id");
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.salary = rs.getInt("salary");
			
			list.add(emp);
		}
		connection.close();
		return list;
	}
	
	
}
