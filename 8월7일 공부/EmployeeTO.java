package myjsp;
// 직원정보를 담은(변수정의) 클래스
public class EmployeeTO {
	public int employeeId;
	public String lastName;
	public String firstName;
	public int salary;
	public String jobId;
	
	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}



	public String getDepartmentId() {
		return departmentId;
	}



	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}



	public String departmentId;

	
	
	public String toString() {
		return "EmpInfo [employee_id=" + employeeId + ",  department_id=" + departmentId + ", last_name=" + lastName + ",salary=" + salary;
	}
}
