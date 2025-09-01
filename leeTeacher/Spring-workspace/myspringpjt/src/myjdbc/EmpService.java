package myjdbc;

import java.util.List;

public interface EmpService {

	void setDAO(EmpDAO dao);

	//메서드를 선언한 것
	public List<Emp> getEmpListByDeptNo(int deptNo) throws Exception;

}
