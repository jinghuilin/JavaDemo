package summer.web.service;

import java.util.List;

import summer.web.entity.Role;

public interface RoleService {
	public Role getByEmpId(int empId);
	
	public List<Role> getAll();
	
	public boolean insert(Role role);
	
	public int delete(int roleId);
	
	public List<Role> getByPage(Role role);
	
	public Role getById(int roleId);
	
	public int update(Role role);
}
