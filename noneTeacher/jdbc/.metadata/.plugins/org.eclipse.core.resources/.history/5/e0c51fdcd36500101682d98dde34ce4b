package project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import exception.SQLQueryException;

public class CreateList {

	static public List<EmpInfo> executeQueryE(String sql, Object params) {// int와 String을 모두 받음
		List<EmpInfo> empList = new ArrayList<>();
		try (PreparedStatement stmt = DBController.conn.prepareStatement(sql)) {
            stmt.setObject(1, params);
			ResultSet rs = stmt.executeQuery(); 
				// while문으로 직원정보를 리스트에 담음 -> empinfo클래스에 변수가 정의되어 있음
			while(rs.next()) {
				EmpInfo emp = new EmpInfo();
				emp.employeeId = rs.getInt("employee_id");
				emp.lastName = rs.getString("last_name");
				emp.salary = rs.getInt("salary");
				emp.email = rs.getString("email");
				emp.hireDate = rs.getString("hire_date");
				emp.firstName = rs.getString("first_name");
				emp.phoneNumber = rs.getString("phone_number");
				emp.jobId = rs.getString("job_id");
				emp.managerId = rs.getString("manager_id");
				emp.departmentId = rs.getString("department_id");
				emp.commissionPct = rs.getDouble("commission_pct");
				
				empList.add(emp);
			}
		} catch (SQLException e) { // 쿼리 실행에 오류 발생 시 실패 메세지 전송
			System.out.println(new SQLQueryException().getMessage());
			MenuController.run();
		}
		return empList;
		}
	
	// 위와 같은 메서드로 집계함수 정보를 담은 리스트 생성과 sql 실행
	static public List<SummaryData> executeQueryS(String sql) {
		List<SummaryData> sumDataList = new ArrayList<>();
		try (PreparedStatement stmt = DBController.conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				SummaryData sum = new SummaryData();
				sum.id = rs.getString("id");
				sum.name = rs.getString("name");
				sum.avg = rs.getString("avg");
				sum.max = rs.getString("max");
				sum.min = rs.getString("min");
				sum.count = rs.getInt("count");
				sum.sum = rs.getString("sum");
				sumDataList.add(sum);
			}
		} catch (SQLException e) { 
			System.out.println(new SQLQueryException().getMessage());
			MenuController.run();
		}
		return sumDataList;
	}
}
