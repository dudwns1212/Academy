package project;
// 직원정보를 담은(변수정의) 클래스
public class EmpInfo {
	public int employeeId;
	public String lastName;
	public String firstName;
	public int salary;
	public String email;
	public String hireDate;
	public String phoneNumber;
	public String jobId;
	public String managerId;
	public String departmentId;
	public double commissionPct;
	
	
	public String toString() {
		return "EmpInfo [employee_id=" + employeeId + ", job_id=" + jobId + ",  department_id=" + departmentId + ",  manager_id=" + managerId + ", last_name=" + lastName + ",     first_name=" + firstName + ",\n\tsalary=" + salary + ",\t email="
				+ email + ",     phone_number=" + phoneNumber + ",\thire_date=" + hireDate + ", commission_pct=" + commissionPct +"]\n";
	}
}
