package summer.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import summer.web.dao.RoleDao;
import summer.web.entity.Role;
import summer.web.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleDao roleDao;
	
	@Override
	public Role getByEmpId(int empId) {
		return roleDao.getByEmpId(empId);
	}
	@Override
	public List<Role> getAll() {
		return roleDao.getAll();
	}
	@Override
	public boolean insert(Role role) {
		return roleDao.insert(role) > 0;
	}
	@Override
	public int delete(int roleId) {
		return roleDao.delete(roleId);
	}
	@Override
	public List<Role> getByPage(Role role) {
		return roleDao.getByPage(role);
	}
	@Override
	public Role getById(int roleId) {
		return roleDao.getById(roleId);
	}
	@Override
	public int update(Role role) {
		return roleDao.update(role);
	}

}
