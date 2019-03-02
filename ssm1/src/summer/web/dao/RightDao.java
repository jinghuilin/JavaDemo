package summer.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import summer.web.entity.Right;
import util.RightUtil;

public interface RightDao {
	public List<Right> getAll();
	
	//��дʵ�����ʱ���ڴ���mapper��ӳ����֮�����ʱ��Ҫ��@Param��Ǹö��󣬲���mapper����(condition.)�ķ�ʽʹ������
	public List<Right> getByPage(@Param("pageSize")int pageSize, @Param("firstResult")int firstResult, @Param("condition")RightUtil condition);
	
	public List<Right> getByRoleId(int roleId);
	
	public int insert(Right right);
	
	public Right getById(int rightId);
	
	public List<Right> getByRightType(int rightType);
	
	public int update(Right right);
	
	public int delete(int rightId);
	
	public List<String> getUrlsByRoleId(int roleId);
}
