package summer.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import summer.web.dao.RightDao;
import summer.web.entity.Right;
import summer.web.service.RightService;
import util.RightUtil;

@Service("rightService")
public class RightServiceImpl implements RightService {
	@Resource
	private RightDao rightDao;
	
	@Override
	public List<Right> getAll() {
		return rightDao.getAll();
	}

	@Override
	public List<Right> getByPage(int pageSize, int pageIndex, RightUtil condition) {
		int firstResult = pageSize*(pageIndex - 1);
		return rightDao.getByPage(pageSize, firstResult, condition);
	}

	@Override
	public List<Right> getByRoleId(int roleId) {
		return rightDao.getByRoleId(roleId);
	}

	@Override
	public boolean insert(Right right) {
		return rightDao.insert(right) > 0;
	}

	@Override
	public Right getById(int rightId) {
		return rightDao.getById(rightId);
	}

	@Override
	public List<Right> getByRightType(int rightType) {
		return rightDao.getByRightType(rightType);
	}

	@Override
	public boolean update(Right right) {
		return rightDao.update(right) > 0;
	}

	@Override
	public int delete(int rightId) {
		return rightDao.delete(rightId);
	}

	@Override
	public List<String> getUrlsByRoleId(int roleId) {
		return rightDao.getUrlsByRoleId(roleId);
	}

}
