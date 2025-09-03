package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	SqlSession session;
	
	public List<Emp> findEmpByYear(int year) throws Exception {
		return session.selectList("findEmpByYear", year);
	}
							
	public List<Emp> findEmpByDeptId(int deptId) throws Exception {
		return session.selectList("findEmpByDeptId", deptId);
	}
	
	public List<Emp> findEmpByName(String firstName) throws Exception {
		return session.selectList("findEmpByName", firstName.toLowerCase());
	}
	
	public List<EmpStat> printStat() throws Exception {
		return session.selectList("printStat");
	}
	
	public List<Emp> findEmpByManagerName(String departname) throws Exception {	
		return session.selectList("findEmpByManagerName", departname.toLowerCase());
	}
	
	public List<Emp> findByCity(String city) throws Exception{
		return session.selectList("findByCity", city);
	}
}
