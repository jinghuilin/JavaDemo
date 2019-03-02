package summer.web.dao;

import java.util.List;

import summer.web.entity.Role;

public interface RoleDao {
	public Role getByEmpId(int empId);
	
	public List<Role> getAll();
	
	public int insert(Role role);
	
	public int delete(int roleId);
	
	public List<Role> getByPage(Role role);
	
	public Role getById(int roleId);
	
	public int update(Role role);
}
