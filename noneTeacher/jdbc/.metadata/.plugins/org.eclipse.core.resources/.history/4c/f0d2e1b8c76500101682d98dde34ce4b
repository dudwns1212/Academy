package project;
import java.util.List;

public class DBMethod { 
	
	// 기능들 메서드
	// 직원이름
	static public void findEmpInfoByEmpName(String fullName) { // 직원이름
	List<EmpInfo> empList = CreateList.executeQueryE(DBConfig.set("getEmpInfoByEmpNameSql"), fullName);
	System.out.println("==이름이 " + fullName + "인 직원정보==");
	if(empList.size()==0) {
		System.out.println("직원이 존재하지 않습니다!");
	}
	for(EmpInfo emp : empList) {
		System.out.println(emp);
		}
	}	
	// 입사년도
	static public void findEmpInfoByHireYear(int year) {
	List<EmpInfo> empList = CreateList.executeQueryE(DBConfig.set("getEmpInfoByHireYearSql"), year);
	System.out.println("==" + year + "년 입사 직원정보==");
	if(empList.size()==0) {
		System.out.println("직원이 존재하지 않습니다!");
	}
	for(EmpInfo emp : empList) {
		System.out.println(emp);
		}
	}
	// 부서번호
	static public void findEmpInfoByDeptId(int deptId) { 
		List<EmpInfo> empList = CreateList.executeQueryE(DBConfig.set("getEmpInfoByDeptIdSql"), deptId);
		System.out.println("==부서번호가 " + deptId + "인 직원정보==");
		if(empList.size()==0) {
			System.out.println("직원이 존재하지 않습니다!");
		}
		for(EmpInfo emp : empList) {
			System.out.println(emp);
		}
	}
	// 직무이름
	static public void findEmpInfoByJobId(String job) { // 직무 작동 ㅇ
		List<EmpInfo> empList = CreateList.executeQueryE(DBConfig.set("getEmpInfoByJobIdSql"), job);
		System.out.println("==" + job + "직군인 직원정보==");
		if(empList.size()==0) {
			System.out.println("직원이 존재하지 않습니다!");
		}
		for(EmpInfo emp : empList) {
			System.out.println(emp);
		}
	}	
	// 도시이름
	static public void findEmpInfoByCity(String cityName) {
		List<EmpInfo> empList = CreateList.executeQueryE(DBConfig.set("getEmpInfoByCityNameSql"), cityName);
		System.out.println("==" + cityName + "에서 근무하는 직원정보==");
		if(empList.size()==0) {
			System.out.println("직원이 존재하지 않습니다!");
		}
		for(EmpInfo emp : empList) {
			System.out.println(emp);
		}
	}
	// 통계자료
	static public void getEmpSummaryData(int selectSummaryN) {
		List<SummaryData> sumDataList;
		
		if(selectSummaryN == 1) {
			sumDataList = CreateList.executeQueryS(DBConfig.set("getSummaryJobSql"));
			System.out.println("==부서별 연봉 통계 [원화기준, 현재환율 : 1390]==");
		}else if(selectSummaryN == 2) {
			sumDataList = CreateList.executeQueryS(DBConfig.set("getSummaryDpIdSql"));
			System.out.println("==직무별 연봉 통계 [원화기준, 현재환율 : 1390]==");
		}else if(selectSummaryN == 3){
			sumDataList = CreateList.executeQueryS(DBConfig.set("getSummaryCitySql"));
			System.out.println("==도시별 연봉 통계 [원화기준, 현재환율 : 1390]==");
		}else if(selectSummaryN == 4){
			sumDataList = CreateList.executeQueryS(DBConfig.set("getSummaryCountrySql"));
			System.out.println("==나라별 연봉 통계 [원화기준, 현재환율 : 1390]==");
		}else if(selectSummaryN == 5){
			sumDataList = CreateList.executeQueryS(DBConfig.set("getSummaryRegionSql"));
			System.out.println("==대륙별 연봉 통계 [원화기준, 현재환율 : 1390]==");
		}else {
			return;
		}
		
		for(SummaryData sum : sumDataList) {
			System.out.println(sum);
		}
	}
	// 매니저 이름
	static public void findEmpInfoByManagerLastName(String managerLastName) { 
		List<EmpInfo> empList = CreateList.executeQueryE(DBConfig.set("getEmpInfoByManagerIdSql"), managerLastName);
		System.out.println("==매니저 성이 " + managerLastName + "인 부서원정보==");
		if(empList.size()==0) {
			System.out.println("직원이 존재하지 않습니다!");
		}
		for(EmpInfo emp : empList) {
			System.out.println(emp);
		}
	}
	// 나라이름
	static public void findEmpInfoByCountryName(String countryName) { 
		List<EmpInfo> empList = CreateList.executeQueryE(DBConfig.set("getEmpInfoByCountryNameSql"), countryName);
		System.out.println("==" + countryName + "에서 근무하는 직원정보==");
		if(empList.size()==0) {
			System.out.println("직원이 존재하지 않습니다!");
		}
		for(EmpInfo emp : empList) {
			System.out.println(emp);
		}
	}
}
	
