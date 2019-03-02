package summer.web.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import summer.web.entity.Employee;
import summer.web.entity.Right;
import summer.web.entity.Role;
import summer.web.service.EmployeeService;
import summer.web.service.RefRoleRightsService;
import summer.web.service.RightService;
import summer.web.service.RoleService;
import util.DateUtil;
import util.EmployeeUtil;
import util.PageUtil;
import util.StringUtil;

@Controller
@RequestMapping(value = "/employee.do")
public class EmployeeController {
	/**
	 * @Resource 注解注入EmployeeController所需要的依赖
	 * 注解方式注入不在需要setter方法，也可以写在setter方法上通过属性名进行匹配，
	 * 这种方式代码更加简洁
	 * employeeService
	 * rightService
	 * roleService
	 */
	@Resource
	private EmployeeService employeeService;

	@Resource
	private RightService rightService;
	
	@Resource
	private RoleService roleService;
	
	
	@Resource
	private Employee employee;
	
	@Resource 
	private RefRoleRightsService refRoleRightsService;
	
	/**
	 * 处理登录请求
	 * @RequestMapping 匹配包含参数action为login的请求路径
	 * 返回ModelAndView对象
	 */
	@RequestMapping(params = "action=login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		//1、收集参数、验证参数  
		String empName = request.getParameter("empName");
		String password = request.getParameter("password");
		//2、绑定参数到命令对象  
		//3、将命令对象传入业务对象进行业务处理  
		Employee employee = employeeService.login(empName, password);
		int roleId = roleService.getByEmpId(employee.getEmpId()).getRoleId();
		List<Right> rightList = rightService.getByRoleId(roleId);
		//4、选择下一个页面  
		ModelAndView mv = new ModelAndView();  
		if(employee != null) {
			//添加模型数据 可以是任意的POJO对象  
			//mv.addObject("loginedEmployee", employee);
			session.setAttribute("loginedEmployee", employee);
			session.setAttribute("rights", rightList);
			session.setAttribute("role", roleService.getByEmpId(employee.getEmpId()));
			//设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面  
			mv.setViewName("index");  
		} 
//			request.setAttribute("message", "用户名或密码错误！");  
//			mv.setViewName("login");  
		
		return mv;
		
	}
	
	
	@RequestMapping(params = "action=logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		session.invalidate();
		mv.setViewName("login");
		return mv;
	}
	
	
	/**
	 * 分页查询
	 */
	@RequestMapping(params = "action=getByPage")
	public ModelAndView getByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		PageUtil pageUtil = new PageUtil();
		EmployeeUtil condition = new EmployeeUtil();
		List<Role> roleList = roleService.getAll();
		String strPageIndex = request.getParameter("pageIndex");
		if(!StringUtil.isNullOrEmpty(strPageIndex)){
			int pageIndex = Integer.parseInt(strPageIndex);
			pageUtil.setPageIndex(pageIndex);
		}
		String empName = request.getParameter("empName");
		if(!StringUtil.isNullOrEmpty(empName)){
			condition.setEmpName(empName.trim());
		}
		String strSex = request.getParameter("sex");
		if(!StringUtil.isNullOrEmpty(strSex)){	
			int sex = Integer.parseInt(strSex);
			condition.setSex(sex);
		}
		String strStartBirthday = request.getParameter("startBirthday");
		if(!StringUtil.isNullOrEmpty(strStartBirthday)){
			Date startBirthday = DateUtil.parse(strStartBirthday.trim());
			condition.setStartBirthday(startBirthday);		
		}
		String strEndBirthday = request.getParameter("endBirthday");
		if(!StringUtil.isNullOrEmpty(strEndBirthday)){
			Date endBirthday = DateUtil.parse(strEndBirthday.trim());
			condition.setEndBirthday(endBirthday);		
		}
		String strRoleId = request.getParameter("roleId");
		if(!StringUtil.isNullOrEmpty(strRoleId)){
			int roleId = Integer.parseInt(strRoleId);		
			condition.setRoleId(roleId);
		}
		String strStatus = request.getParameter("status");
		if(!StringUtil.isNullOrEmpty(strStatus)){
			int status = Integer.parseInt(strStatus);		
			condition.setStatus(status);
		}
		List<Employee> empList = employeeService.getByPage(pageUtil.getPageSize(), pageUtil.getPageIndex(), condition);
		int totalRecords = employeeService.getByPage(0,0,condition).size();
		pageUtil.setTotalRecords(totalRecords);
		HttpSession session = request.getSession();
		session.setAttribute("empList", empList);
		request.setAttribute("roleList", roleList);
		request.setAttribute("condition", condition);
		session.setAttribute("pageUtil", pageUtil);
		mv.setViewName("employee/index");
		return mv;
	}
	
	/**
	 * 到添加用户页面之前先获取roleList
	 */
	@RequestMapping(params = "action=addEmployee")
	public ModelAndView addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<Role> roleList = roleService.getAll();
		request.setAttribute("roleList", roleList);
		mv.setViewName("employee/addEmployee");
		return mv;
	}
	@RequestMapping(params = "action=insert")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Employee employee = new Employee();
		String empName = request.getParameter("empName");
		if(!StringUtil.isNullOrEmpty(empName)) {
			employee.setEmpName(empName);
		}
		String password = request.getParameter("password");
		if(!StringUtil.isNullOrEmpty(password)) {			
			employee.setPassword(password);
		}
		String strSex = request.getParameter("sex");
		if(!StringUtil.isNullOrEmpty(strSex)) {
			int  sex = Integer.parseInt(strSex);
			employee.setSex(sex);
		}
		String strBirthday = request.getParameter("birthday");
		if(!StringUtil.isNullOrEmpty(strBirthday)) {
			Date birthday = DateUtil.parse(strBirthday);
			employee.setBirthday(birthday);
		}
		String strRoleId = request.getParameter("roleId");
		if(!StringUtil.isNullOrEmpty(strRoleId)) {
			int roleId = Integer.parseInt(strRoleId);		
			employee.setRoleId(roleId);
		}
		String strStatus = request.getParameter("status");
		if(!StringUtil.isNullOrEmpty(strStatus)) {
			int status = Integer.parseInt(strStatus);		
			employee.setStatus(status);
		}
		boolean addSuccess = employeeService.insert(employee);
		request.setAttribute("success", addSuccess);
		
		mv.setViewName("employee/addEmployee");
		return mv;
	}
	
	@RequestMapping(params = "action=getById")
	public ModelAndView getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<Role> roleList = roleService.getAll();
		String strEmpId = request.getParameter("empId");
		int empId = 0;
		if(!StringUtil.isNullOrEmpty(strEmpId)) {
			empId = Integer.parseInt(strEmpId);
		}
		employee = employeeService.getById(empId);
		request.setAttribute("employee", employee);
		request.setAttribute("roleList", roleList);
		mv.setViewName("employee/updateEmployee");
		return mv;
	}
	
	@RequestMapping(params = "action=getById2")
	public ModelAndView getById2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<Role> roleList = roleService.getAll();
		String strEmpId = request.getParameter("empId");
		int empId = 0;
		if(!StringUtil.isNullOrEmpty(strEmpId)) {
			empId = Integer.parseInt(strEmpId);
		}
		employee = employeeService.getById(empId);
		request.setAttribute("employee", employee);
		request.setAttribute("roleList", roleList);
		mv.setViewName("employee/updateEmployee2");
		return mv;
	}
	
	@RequestMapping(params = "action=update")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<Role> roleList = roleService.getAll();
		String strEmpId = request.getParameter("empId");
		int empId = 0;
		if(!StringUtil.isNullOrEmpty(strEmpId)) {
			empId = Integer.parseInt(strEmpId);
			employee.setEmpId(empId);
		}
		String empName = request.getParameter("empName");
		employee.setEmpName(empName);
		String password = request.getParameter("password");
		employee.setPassword(password);
		String strSex = request.getParameter("sex");
		int sex = Integer.parseInt(strSex);
		employee.setSex(sex);
		String strBirthday = request.getParameter("birthday");
		Date birthday = DateUtil.parse(strBirthday);
		employee.setBirthday(birthday);
		String strRoleId = request.getParameter("roleId");
		int roleId = Integer.parseInt(strRoleId);		
		employee.setRoleId(roleId);
		String strStatus = request.getParameter("status");
		int status = Integer.parseInt(strStatus);		
		employee.setStatus(status);
		boolean success = employeeService.update(employee);
		request.setAttribute("employee", employee);
		request.setAttribute("roleList", roleList);
		request.setAttribute("success", success);
		mv.setViewName("employee/updateEmployee");
		return mv;
		
	}
	@RequestMapping(params = "action=delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		PageUtil pageUtil = new PageUtil();
		EmployeeUtil condition = new EmployeeUtil();
		int totalRecords = employeeService.getByPage(0,0,condition).size();
		pageUtil.setTotalRecords(totalRecords);
		int empId = Integer.parseInt(request.getParameter("empId"));
		employeeService.delete(empId);
		List<Employee> empList = employeeService.getByPage(pageUtil.getPageSize(), pageUtil.getPageIndex(), condition);
		HttpSession session = request.getSession();
		session.setAttribute("empList", empList);
		session.setAttribute("pageUtil", pageUtil);
		mv.setViewName("employee/index");
		return mv;
	}
	@RequestMapping(params = "action=testEmpName")
	public void testEmpName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String empName = request.getParameter("empName");
		employee = employeeService.getByName(empName);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  response.getWriter();
		if(employee == null) {
			out.print(true);
		}else {
			out.print(false);
		}
		out.flush();
		out.close();
	}
}
