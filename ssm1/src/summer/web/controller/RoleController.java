package summer.web.controller;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import summer.web.entity.Role;
import summer.web.service.RoleService;
import util.StringUtil;
@Controller
@RequestMapping(value = "/role.do")
public class RoleController {
	@Resource
	private RoleService roleService;
	@Resource
	private Role role;
	
	
	@RequestMapping(params = "action=getByPage")
	public ModelAndView getByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Role role = new Role();
		String roleName = request.getParameter("roleName");
		String strStatus = request.getParameter("status");
		if(!StringUtil.isNullOrEmpty(roleName)) {
			role.setRoleName(roleName);
		}
		if(!StringUtil.isNullOrEmpty(strStatus)) {
			int status = Integer.parseInt(strStatus);
			role.setStatus(status);
		}else {
			role.setStatus(-1);
		}
		List<Role> roleList = roleService.getByPage(role);
		HttpSession session = request.getSession();
		request.setAttribute("role", role);
		session.setAttribute("roleList", roleList);
		mv.setViewName("role/index");
		return mv;
	}
/*	@RequestMapping(params = "action=getAll")
	public ModelAndView getAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		List<Role> roleList = roleService.getAll();
		session.setAttribute("roleList", roleList);
		mv.setViewName("role/index");
		return mv;
	}*/
	
	@RequestMapping(params = "action=getById")
	public ModelAndView getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		role = roleService.getById(roleId);
		request.setAttribute("role", role);
		mv.setViewName("role/updateRole");
		return mv;
	}
	
	@RequestMapping(params = "action=insert")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String roleName = request.getParameter("roleName");
		String roleDesc = request.getParameter("roleDesc");
		int status = Integer.parseInt(request.getParameter("status"));
		role.setRoleName(roleName);
		role.setRoleDesc(roleDesc);
		role.setStatus(status);
		boolean success = roleService.insert(role);
		request.setAttribute("success", success);
		mv.setViewName("role/addRole");
		return mv;
	}
	
	@RequestMapping(params = "action=delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		roleService.delete(roleId);
		List<Role> roleList = roleService.getAll();
		HttpSession session = request.getSession();
		session.setAttribute("roleList", roleList);
		mv.setViewName("role/index");
		return mv;
	}
	
	@RequestMapping(params = "action=update")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String strRoleId = request.getParameter("roleId");
		int roleId = Integer.parseInt(strRoleId);
		String roleName = request.getParameter("roleName");
		String roleDesc = request.getParameter("roleDesc");
		String strStatus = request.getParameter("status");
		int status = Integer.parseInt(strStatus);
		role.setRoleId(roleId);
		role.setRoleName(roleName);
		role.setRoleDesc(roleDesc);
		role.setStatus(status);
		boolean success = roleService.update(role) > 0;
		request.setAttribute("success", success);
		request.setAttribute("role", role);
		mv.setViewName("role/updateRole");
		return mv;
	}
}
