package summer.web.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import summer.web.dao.RightDao;
import summer.web.entity.Right;
import util.RightUtil;

@Repository("rightDao")
public class RightDaoImpl implements RightDao {
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public List<Right> getAll() {
		List<Right> rightList = sqlSessionFactory.openSession().selectList("summer.web.right.dao.RightDao.getAll");
		return rightList;
	}

	@Override
	public List<Right> getByPage(int pageSize, int pageIndex, RightUtil condition) {
		Map<String, Object> map = new HashMap<>();
		map.put("rightName", condition.getRightName());
		map.put("status", condition.getStatus());
		map.put("parentId", condition.getParentId());
		map.put("firstResult", pageSize*(pageIndex-1));
		map.put("pageSize", pageSize);
		List<Right> rightList = sqlSessionFactory.openSession().selectList("summer.web.right.dao.RightDao.getByPage", map);
		return rightList;
	}

	@Override
	public List<Right> getByRoleId(int roleId) {
		return sqlSessionFactory.openSession().selectList("summer.web.right.dao.RightDao.getByRoleId", roleId);
	}

	@Override
	public int insert(Right right) {
		Map<String, Object> map = new HashMap<>();
		map.put("rightName", right.getRightName());
		map.put("rightDesc", right.getRightDesc());
		map.put("parentId", right.getParentId());
		map.put("rightUrl", right.getRightUrl());
		map.put("rightType", right.getRightType());
		map.put("status", right.getStatus());
		return sqlSessionFactory.openSession().insert("summer.web.right.dao.RightDao.insert", map);
	}

	@Override
	public Right getById(int rightId) {
		return sqlSessionFactory.openSession().selectOne("summer.web.right.dao.RightDao.getById", rightId);
	}

	@Override
	public List<Right> getByRightType(int rightType) {
		return sqlSessionFactory.openSession().selectList("summer.web.right.dao.RightDao.getByRightType", rightType);
	}

	@Override
	public int update(Right right) {
		return sqlSessionFactory.openSession().update("summer.web.right.dao.RightDao.update", right);
	}

	@Override
	public int delete(int rightId) {
		return sqlSessionFactory.openSession().delete("summer.web.right.dao.RightDao.delete", rightId);
	}

	@Override
	public List<String> getUrlsByRoleId(int roleId) {
		return sqlSessionFactory.openSession().selectList("summer.web.right.dao.RightDao.getUrlsByRoleId", roleId);
	}
	
	

}
