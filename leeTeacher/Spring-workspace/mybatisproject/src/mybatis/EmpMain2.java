package mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//과제를 실행시켜보고 싶어서 만든 클래스
public class EmpMain2 {
	public static void main(String[] args) throws Exception {
		System.out.print("직무ID:");
		Scanner scan = new Scanner(System.in);
		String jobId = scan.nextLine();
		while(jobId!=null) {
			System.out.println(jobId);
			List<Emp> empList = EmpDAOMybatis.getEmpListByJobId(jobId);
			for(Emp emp : empList) {
				System.out.println(emp);
			}
			System.out.println("부서번호(0은 종료):");
			System.out.print("직무ID:");
			jobId = scan.nextLine();
		}
	}
}
