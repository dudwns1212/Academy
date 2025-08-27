package myjdbc;

import java.util.List;
import java.util.Scanner;

public class EmpMain2 {
	public static void main(String[] args) throws Exception {
		//부서번호를 입력받아서 그 부서에 근무하는 사원들의 목록을 출력함
		System.out.println("job_id : " );
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String job_id = scan.nextLine();
		while(job_id!=null && job_id.length()!=0) {
		System.out.println(job_id);
		//부서번호를 전달받아서 그 부서의 부서원정보를 리턴함
		List<Emp> empList = EmpDAO.getEmpListByJobId(job_id); 
		for(Emp emp : empList) {
			System.out.println(emp);
		}
		System.out.print("job_id(엔터->종료)");
		job_id = scan.nextLine();
		}
	}
}
	
