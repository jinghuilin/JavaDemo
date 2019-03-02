package summer.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import summer.web.entity.Right;
import summer.web.service.RefRoleRightsService;
import summer.web.service.RightService;
import util.PageUtil;
import util.RightUtil;
import util.StringUtil;

@Controller
@RequestMapping(value = "/right.do")
public class RightController {
	@Resource
	private RightService rightService;
	
	@Resource
	private Right right;
	
	
	@Resource
	private RefRoleRightsService refRoleRightsService;
	
	
	
	@RequestMapping(params = "action=getByPage")
	public ModelAndView getByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		PageUtil pageUtil = new PageUtil();
		RightUtil condition = new RightUtil();
		List<Right> oneRightList = rightService.getByRightType(1);
		String strPageIndex = request.getParameter("pageIndex");
		String rightName = request.getParameter("rightName");
		String strStatus = request.getParameter("status");
		String strParentId = request.getParameter("parentId");
		if(!StringUtil.isNullOrEmpty(strPageIndex)){
			int pageIndex = Integer.parseInt(strPageIndex);
			pageUtil.setPageIndex(pageIndex);
		}
		if(!StringUtil.isNullOrEmpty(rightName)) {
			condition.setRightName(rightName);
		}
		if(!StringUtil.isNullOrEmpty(strStatus)) {
			int status = Integer.parseInt(strStatus);
			condition.setStatus(status);
		}
		if(!StringUtil.isNullOrEmpty(strParentId)) {
			int parentId = Integer.parseInt(strParentId);
			condition.setParentId(parentId);
		}
		int totalRecords = rightService.getByPage(0, 0, condition).size();
		pageUtil.setTotalRecords(totalRecords);
		List<Right> rightList = rightService.getByPage(pageUtil.getPageSize(), pageUtil.getPageIndex(), condition);
		HttpSession session = request.getSession();
		session.setAttribute("rightList", rightList);
		request.setAttribute("condition",condition);
		request.setAttribute("oneRightList", oneRightList);
		session.setAttribute("pageUtil", pageUtil);
		mv.setViewName("right/index");
		return mv;
	}
	
	@RequestMapping(params = "action=update")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String strRightId = request.getParameter("rightId");
		String rightName = request.getParameter("rightName");
		String rightDesc = request.getParameter("rightDesc");
		String strParentId = request.getParameter("parentId");
		String rightUrl = request.getParameter("rightUrl");
		String strRightType = request.getParameter("rightType");
		String strStatus = request.getParameter("status");
		if(!StringUtil.isNullOrEmpty("strRightId")) {
			right.setRightId(Integer.parseInt(strRightId));
		}
		if(!StringUtil.isNullOrEmpty("rightName")) {
			right.setRightName(rightName);
		}
		if(!StringUtil.isNullOrEmpty("rightDesc")) {
			right.setRightDesc(rightDesc);
		}
		if(!StringUtil.isNullOrEmpty("strParentId")) {
			right.setParentId(Integer.parseInt(strParentId));
		}
		if(!StringUtil.isNullOrEmpty("rightUrl")) {
			right.setRightUrl(rightUrl);
		}
		if(!StringUtil.isNullOrEmpty("strRightType")) {
			right.setRightType(Integer.parseInt(strRightType));
		}
		if(!StringUtil.isNullOrEmpty("strStatus")) {
			right.setStatus(Integer.parseInt(strStatus));
		}
		List<Right> rightList = rightService.getByRightType(1);
		boolean success= rightService.update(right);
		request.setAttribute("rightList", rightList);
		request.setAttribute("right", right);
		request.setAttribute("success", success);
		mv.setViewName("right/updateRight");
		return mv;
	}
	
	@RequestMapping(params = "action=insertOne")
	public ModelAndView insertOne(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Right right = new Right();
		String rightName = request.getParameter("rightName");
		String rightDesc = request.getParameter("rightDesc");
		String strRightType = request.getParameter("rightType");
		String strStatus = request.getParameter("status");
		if(!StringUtil.isNullOrEmpty("rightName")) {
			right.setRightName(rightName);
		}
		if(!StringUtil.isNullOrEmpty("rightDesc")) {
			right.setRightDesc(rightDesc);
		}
		if(!StringUtil.isNullOrEmpty("strRightType")) {
			right.setRightType(Integer.parseInt(strRightType));
		}
		if(!StringUtil.isNullOrEmpty("strStatus")) {
			right.setStatus(Integer.parseInt(strStatus));
		}
		boolean success= rightService.insert(right);
		request.setAttribute("success", success);
		mv.setViewName("right/addRight");
		return mv;
	}
	
	@RequestMapping(params = "action=insert")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String rightName = request.getParameter("rightName");
		String rightDesc = request.getParameter("rightDesc");
		String strParentId = request.getParameter("parentId");
		String rightUrl = request.getParameter("rightUrl");
		String strRightType = request.getParameter("rightType");
		String strStatus = request.getParameter("status");
		if(!StringUtil.isNullOrEmpty("rightName")) {
			right.setRightName(rightName);
		}
		if(!StringUtil.isNullOrEmpty("rightDesc")) {
			right.setRightDesc(rightDesc);
		}
		if(!StringUtil.isNullOrEmpty("strParentId")) {
			right.setParentId(Integer.parseInt(strParentId));
		}
		if(!StringUtil.isNullOrEmpty("rightUrl")) {
			right.setRightUrl(rightUrl);
		}
		if(!StringUtil.isNullOrEmpty("strRightType")) {
			right.setRightType(Integer.parseInt(strRightType));
		}
		if(!StringUtil.isNullOrEmpty("strStatus")) {
			right.setStatus(Integer.parseInt(strStatus));
		}
		boolean success= rightService.insert(right);
		request.setAttribute("success", success);
		mv.setViewName("right/addSecondRight");
		return mv;
	}
	
	@RequestMapping(params = "action=delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		PageUtil pageUtil = new PageUtil();
		RightUtil condition = new RightUtil();
		int rightId = Integer.parseInt(request.getParameter("rightId"));
		rightService.delete(rightId);
		int totalRecords = rightService.getByPage(0, 0, condition).size();
		pageUtil.setTotalRecords(totalRecords);
		List<Right> rightList = rightService.getByPage(pageUtil.getPageSize(), pageUtil.getPageIndex(), condition);
		HttpSession session = request.getSession();
		session.setAttribute("rightList", rightList);
		session.setAttribute("pageUtil", pageUtil);
		mv.setViewName("right/index");
		return mv;
	}
	
	/**
	 *为执行分配权限操作执行查询全部权限
	 */
	@RequestMapping(params = "action=getAll")
	public ModelAndView getAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		List<Right> rightList = rightService.getAll();
		List<Integer> refRightIdList = refRoleRightsService.getById(roleId);
		request.setAttribute("rightList", rightList);
		request.setAttribute("refRightIdList", refRightIdList);
		request.setAttribute("roleId", roleId);
		mv.setViewName("role/addRight");
		return mv;
	}
	
	@RequestMapping(params = "action=getById")
	public ModelAndView getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		int rightId = Integer.parseInt(request.getParameter("rightId"));
		Right right = rightService.getById(rightId);
		List<Right> rightList = rightService.getByRightType(1);
		request.setAttribute("rightList", rightList);
		request.setAttribute("right", right);
		mv.setViewName("right/updateRight");
		return mv;
	}
	
	@RequestMapping(params = "action=createSecondRight")
	public ModelAndView createSecondRight(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<Right> rightList = rightService.getByRightType(1);
		request.setAttribute("rightList", rightList);
		mv.setViewName("right/addSecondRight");
		return mv;
	}
}
