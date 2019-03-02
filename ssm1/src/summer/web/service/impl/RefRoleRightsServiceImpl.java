package summer.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import summer.web.dao.RefRoleRightsDao;
import summer.web.service.RefRoleRightsService;

@Service("refRoleRightsService")
public class RefRoleRightsServiceImpl implements RefRoleRightsService {
	@Resource
	private RefRoleRightsDao refRoleRightsDao;
	
	@Override
	public boolean insert(int roleId, List<Integer> rightIdList) {
		refRoleRightsDao.delete(roleId);
		boolean success = false;
		for(int rightId : rightIdList) {
			success = refRoleRightsDao.insert(roleId, rightId) > 0;
		}
		return success;
	}

	@Override
	public List<Integer> getById(int roleId) {
		return refRoleRightsDao.getById(roleId);
	}


}
