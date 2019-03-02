package summer.web.dao;

import java.util.List;



public interface RefRoleRightsDao {
	public int insert(int roleId, int rightId);
	
	public List<Integer> getById(int roleId);
	
	public int delete(int roleId);
}
