package summer.web.service;

import java.util.List;


public interface RefRoleRightsService {
	public boolean insert(int roleId, List<Integer> rightIdList);
	
	public List<Integer> getById(int roleId);
	
}
