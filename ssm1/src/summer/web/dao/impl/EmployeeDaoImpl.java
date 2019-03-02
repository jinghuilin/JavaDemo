package summer.web.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import summer.web.dao.EmployeeDao;
import summer.web.entity.Employee;
import util.EmployeeUtil;


@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public Employee getByName(String empName) {
		Employee employee = sqlSessionFactory.openSession().selectOne("summer.web.employee.dao.EmployeeDao.getByName",empName);
		return employee;
	}

	@Override
	public List<Employee> getByPage(int pageSize, int pageIndex, EmployeeUtil condition) {
		List<Employee> empList = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
		map.put("empName", condition.getEmpName());
		map.put("sex", condition.getSex());
		map.put("startBirthday", condition.getStartBirthday());
		map.put("endBirthday", condition.getEndBirthday());
		map.put("roleId", condition.getRoleId());
		map.put("status", condition.getStatus());
		map.put("firstResult", pageSize*(pageIndex-1));
		map.put("pageSize", pageSize);
		empList = sqlSessionFactory.openSession().selectList("summer.web.employee.dao.EmployeeDao.getByPage", map);
		return empList;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> empList = sqlSessionFactory.openSession().selectList("summer.web.employee.dao.EmployeeDao.getAll");
		return empList;
	}

	@Override
	public int insert(Employee employee) {
		return sqlSessionFactory.openSession().insert("summer.web.employee.dao.EmployeeDao.insert", employee);
	}

	@Override
	public Employee getById(int empId) {
		return sqlSessionFactory.openSession().selectOne("summer.web.employee.dao.EmployeeDao.getById", empId);
	}

	@Override
	public int update(Employee employee) {
		return sqlSessionFactory.openSession().update("summer.web.employee.dao.EmployeeDao.update", employee);
	}
	
	public int delete(int empId) {
		return sqlSessionFactory.openSession().delete("summer.web.employee.dao.EmployeeDao.delete", empId);
	}
}
