package summer.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import summer.web.service.RefRoleRightsService;

@Controller
@RequestMapping(value = "/refRoleRights.do")
public class RefRoleRightsController {
	@Resource
	private RefRoleRightsService refRoleRightsService;
	
	@RequestMapping(params = "action=insert")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		int rightId = 0;
		String[] rights = request.getParameterValues("rights");
		List<Integer> rightIdList = new ArrayList<>();
		for(String strRightId : rights) {
			rightId = Integer.parseInt(strRightId);
			rightIdList.add(rightId);
		}
		boolean success = refRoleRightsService.insert(roleId, rightIdList);
		request.setAttribute("success", success);
		mv.setViewName("role/index");
		return mv;
	}
}
