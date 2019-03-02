package summer.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import summer.web.entity.Employee;
import util.EmployeeUtil;

public interface EmployeeDao {
	public Employee getByName(String empName);
	
	public List<Employee> getByPage(@Param("pageSize")int pageSize, @Param("firstResult")int firstResult, @Param("condition")EmployeeUtil condition);
	
	public List<Employee> getAll();
	
	public int insert(Employee employee);
	
	public Employee getById(int empId);
	
	public int update(Employee employee);
	
	public int delete(int empId);
}
