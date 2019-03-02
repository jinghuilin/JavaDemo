package summer.web.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import summer.web.dao.RefRoleRightsDao;
@Repository("refRoleRightsDao")
public class RefRoleRightsDaoImpl implements RefRoleRightsDao {
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	@Override
	public int insert(int roleId, int rightId) {
		Map<String, Object> map = new HashMap<>();
		map.put("roleId", roleId);
		map.put("rightId", rightId);
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("summer.web.refRoleRights.dao.RefRoleRightsDao.insert", map);
	}
	@Override
	public List<Integer> getById(int roleId) {
		List<Integer> refRightIdList = sqlSessionFactory.openSession().selectList("summer.web.refRoleRights.dao.RefRoleRightsDao.getById", roleId);
		return refRightIdList;
	}
	@Override
	public int delete(int roleId) {
		return sqlSessionFactory.openSession().delete("summer.web.refRoleRights.dao.RefRoleRightsDao.delete", roleId);
	}

}
