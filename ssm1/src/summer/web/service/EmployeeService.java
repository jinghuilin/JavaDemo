package summer.web.service;

import java.util.List;

import summer.web.entity.Employee;
import util.EmployeeUtil;

public interface EmployeeService {
	public Employee login(String empName, String password);
	
	public List<Employee> getByPage(int pageSize, int pageIndex, EmployeeUtil condition);
	
	public List<Employee> getAll();
	
	public boolean insert(Employee employee);
	
	public Employee getById(int empId);
	
	public boolean update(Employee employee);
	
	public Employee getByName(String empName);
	
	public boolean delete(int empId);
}
