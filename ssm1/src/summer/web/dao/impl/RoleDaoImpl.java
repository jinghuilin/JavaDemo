package summer.web.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import summer.web.dao.RoleDao;
import summer.web.entity.Role;

@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public Role getByEmpId(int empId) {
		Role role = sqlSessionFactory.openSession().selectOne("summer.web.role.dao.RoleDao.getByEmpId", empId);
		return role;
	}
	@Override
	public List<Role> getAll() {
		List<Role> roleList = sqlSessionFactory.openSession().selectList("summer.web.role.dao.RoleDao.getAll");
		return roleList;
	}
	@Override
	public int insert(Role role) {
		Map<String, Object> map = new HashMap<>();
		map.put("roleName", role.getRoleName());
		map.put("roleDesc", role.getRoleDesc());
		map.put("status", role.getStatus());
		return sqlSessionFactory.openSession().insert("summer.web.role.dao.RoleDao.insert", map);
	}
	@Override
	public int delete(int roleId) {
		return sqlSessionFactory.openSession().delete("summer.web.role.dao.RoleDao.delete", roleId);
	}
	@Override
	public List<Role> getByPage(Role role) {
		Map<String, Object> map = new HashMap<>();
		map.put("roleName", role.getRoleName());
		map.put("status", role.getStatus());
		return sqlSessionFactory.openSession().selectList("summer.web.role.dao.RoleDao.getByPage", map);
	}
	@Override
	public Role getById(int roleId) {
		return sqlSessionFactory.openSession().selectOne("summer.web.role.dao.RoleDao.getById", roleId);
	}
	@Override
	public int update(Role role) {
		return sqlSessionFactory.openSession().update("summer.web.role.dao.RoleDao.update", role);
	}
	
	
	
	

}
