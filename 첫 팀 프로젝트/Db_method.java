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
	public List<EmpInfo> executeQuery(String sql, Object... params) {
		List<EmpInfo> empList = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
				}
				ResultSet rs = stmt.executeQuery();
		
				while(rs.next()) {
					EmpInfo emp = new EmpInfo();
					emp.employee_id = rs.getInt("employee_id");
					emp.last_name = rs.getString("last_name");
					emp.salary = rs.getInt("salary");
					empList.add(emp);
			}
		} catch (SQLException e) {
				 System.out.println("쿼리 실행 오류: " + e.getMessage());
		}
		return empList;
		}
	
	// 메서드로 sql이랑 값들 받아서 통계리스트를 만들어주는 함수
	public List<SummryData> AvgMaxMin(String sql, Object... params) {
		List<SummryData> sumDataList = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
				}
				ResultSet rs = stmt.executeQuery();
		
				while(rs.next()) {
					SummryData sum = new SummryData();
					sum.id = rs.getString("id");
					sum.name = rs.getString("name");
					sum.avg = rs.getString("avg");
					sum.max = rs.getString("max");
					sum.min = rs.getString("min");
					sum.count = rs.getInt("count");
					sumDataList.add(sum);
			}
		} catch (SQLException e) {
				 System.out.println("쿼리 실행 오류: " + e.getMessage());
		}
		return sumDataList;
	}
	
	//기능들
		public void findEmpInfoByEmpName(String fullName) { // 직원이름
		List<EmpInfo> empList = executeQuery(dbc.set("getEmpInfoByEmpNameSql"), fullName);
		System.out.println("==이름이 " + fullName + "인 직원정보==");
		for(EmpInfo emp : empList) {
			System.out.println(emp);
			}
		}	
		public void findEmpInfoByHireYear(int year) { // 입사년도 작동 ㅇ
		List<EmpInfo> empList = executeQuery(dbc.set("getEmpInfoByHireYearSql"), year);
		System.out.println("==" + year + "년 입사 직원정보==");
		for(EmpInfo emp : empList) {
			System.out.println(emp);
			}
		}
		public void findEmpInfoByDeptId(int deptId) { // 부서번호 작동 o
			List<EmpInfo> empList = executeQuery(dbc.set("getEmpInfoByDeptIdSql"), deptId);
			System.out.println("==부서번호가 " + deptId + "인 직원정보==");
			for(EmpInfo emp : empList) {
				System.out.println(emp);
			}
		}
		public void findEmpInfoByJobId(String job) { // 직무 작동 ㅇ
			List<EmpInfo> empList = executeQuery(dbc.set("getEmpInfoByJobIdSql"), job);
			System.out.println("==" + job + "직군인 직원정보==");
			for(EmpInfo emp : empList) {
				System.out.println(emp);
			}
		}	
		public void findEmpInfoByCity(String cityName) {
			List<EmpInfo> empList = executeQuery(dbc.set("getEmpInfoByCityNameSelect"), cityName);
			System.out.println("==" + cityName + "에서 근무하는 직원정보==");
			for(EmpInfo emp : empList) {
				System.out.println(emp);
			}
		}
		public void getEmpSummaryData(int selectSummaryN) {
			List<SummryData> sumDataList;
			if(selectSummaryN == 1) {
				sumDataList = AvgMaxMin(dbc.set("sumDpId"));
				System.out.println("==부서별 연봉 통계입니다==");
			}else if(selectSummaryN == 2) {
				sumDataList = AvgMaxMin(dbc.set("sumJob"));
				System.out.println("==직무별 연봉 통계입니다==");
			}else if(selectSummaryN == 3){
				sumDataList = AvgMaxMin(dbc.set("sumCity"));
				System.out.println("==도시별 연봉 통계입니다==");
			}else if(selectSummaryN == 4){
				sumDataList = AvgMaxMin(dbc.set("sumCountry"));
				System.out.println("==나라별 연봉 통계입니다==");
			}else if(selectSummaryN == 5){
				sumDataList = AvgMaxMin(dbc.set("sumRegion"));
				System.out.println("==대륙별 연봉 통계입니다==");
			}
			for(SummryData sum : sumDataList) {
				System.out.println(sum);
			}
		}
		public void findEmpInfoByManagerLastName(String managerLastName) { 
			List<EmpInfo> empList = executeQuery(dbc.set("getEmpInfoByManagerId"), managerLastName);
			System.out.println("==매니저 성이 " + managerLastName + "인 부서원정보==");
			for(EmpInfo emp : empList) {
				System.out.println(emp);
			}
		}
		public void findEmpInfoByCountryName(String countryName) { // 나라이름
			List<EmpInfo> empList = executeQuery(dbc.set("getEmpInfoByCountryName"), countryName);
			System.out.println("==" + countryName + "에서 근무하는 직원정보==");
			for(EmpInfo emp : empList) {
				System.out.println(emp);
			}
		}
		
		public void close() {
			try {
				if (conn != null && !conn.isClosed()) {
						conn.close();
						System.out.println("DB 연결 해제");
				}
			} catch (SQLException e) {
					
			}
		}

	
}
	
