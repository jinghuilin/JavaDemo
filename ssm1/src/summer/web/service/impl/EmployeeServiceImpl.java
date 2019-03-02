package summer.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import summer.web.dao.EmployeeDao;
import summer.web.entity.Employee;
import summer.web.service.EmployeeService;
import util.EmployeeUtil;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Resource
	private EmployeeDao employeeDao;
	
	@Override
	public Employee login(String empName, String password) {
		Employee employee = employeeDao.getByName(empName);
		if(employee.getPassword().equals(password)) {
			return employee;
		}else {
			return null;
		}
	}
	
	public List<Employee> getByPage(int pageSize, int pageIndex, EmployeeUtil condition) {	
		int firstResult = pageSize*(pageIndex - 1);
		List<Employee> empList = employeeDao.getByPage(pageSize, firstResult, condition);
		return empList;
	}

	public List<Employee> getAll() {
		List<Employee> empList = employeeDao.getAll();
		return empList;
	}
	
	public boolean insert(Employee employee) {
		return employeeDao.insert(employee) > 0;
	}

	@Override
	public Employee getById(int empId) {
		return employeeDao.getById(empId);
	}

	@Override
	public boolean update(Employee employee) {
		return employeeDao.update(employee) > 0;
	}

	@Override
	public Employee getByName(String empName) {
		return employeeDao.getByName(empName);
	}

	@Override
	public boolean delete(int empId) {
		return employeeDao.delete(empId) > 0;
	}
}
