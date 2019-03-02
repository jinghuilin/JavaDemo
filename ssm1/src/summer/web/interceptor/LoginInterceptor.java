package summer.web.interceptor;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import summer.web.entity.Employee;
import summer.web.service.RightService;
import util.StringUtil;

/** 
 * 登录认证的拦截器 
 */ 
public class LoginInterceptor implements  HandlerInterceptor {
	@Resource 
	private RightService rightService;
	/** 
     * Handler执行完成之后调用这个方法 
     */ 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	 /** 
     * Handler执行之后，ModelAndView返回之前调用这个方法 
     */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	 /** 
     * Handler执行之前调用这个方法 
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//获取请求的URL  
        StringBuilder url = new StringBuilder();
        url.append(request.getServletPath()).append("?action=").append(request.getParameter("action")); 
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制  
        if(url.toString().contains("/employee.do?action=login")){
        	return true;
        }  
        if(url.toString().contains("/employee.do?action=testEmpName")) {
        	return true;
        }
        
        
        //获取Session  
        HttpSession session = request.getSession();  
        Employee employee = (Employee)session.getAttribute("loginedEmployee");  
        int roleId = employee.getRoleId();
        List<String> rightUrls = rightService.getUrlsByRoleId(roleId);
        for(String rightUrl : rightUrls) {
        	if(!StringUtil.isNullOrEmpty(rightUrl)) {
	        	if(url.toString().contains(rightUrl)) {
	        		return true;
	        	}
        	}
        }
        /*if(employee != null){ 
        	
        	return true;  
        }*/
        //不符合条件的，跳转到登录界面  
        
        //TODO 做拦截的事情 
	    request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);  
	          
	    return false;  
        
    
	}

}
