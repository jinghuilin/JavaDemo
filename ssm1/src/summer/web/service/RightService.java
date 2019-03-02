package summer.web.service;

import java.util.List;

import summer.web.entity.Right;
import util.RightUtil;

public interface RightService {
	public List<Right> getAll();
	
	public List<Right> getByPage(int pageSize, int pageIndex, RightUtil condition);
	
	public List<Right> getByRoleId(int roleId);
	
	public boolean insert(Right right);
	
	public Right getById(int rightId);
	
	public List<Right> getByRightType(int rightType);
	
	public boolean update(Right right);
	
	public int delete(int rightId);
	
	public List<String> getUrlsByRoleId(int roleId);
}
