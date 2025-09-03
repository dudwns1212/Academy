package springproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public interface EmpService {

	public List<Emp> findEmpByYear(int year) throws Exception;
	
	public List<Emp> findEmpByDeptId(int deptId) throws Exception;
	
	public List<Emp> findEmpByName(String firstName) throws Exception;
	
	public List<EmpStat> printStat() throws Exception;
	
	public List<Emp> findEmpByManagerName(String departname) throws Exception;
	
	public List<Emp> findByCity(String city) throws Exception;
	
}
