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
 * ��¼��֤�������� 
 */ 
public class LoginInterceptor implements  HandlerInterceptor {
	@Resource 
	private RightService rightService;
	/** 
     * Handlerִ�����֮������������ 
     */ 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	 /** 
     * Handlerִ��֮��ModelAndView����֮ǰ����������� 
     */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	 /** 
     * Handlerִ��֮ǰ����������� 
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//��ȡ�����URL  
        StringBuilder url = new StringBuilder();
        url.append(request.getServletPath()).append("?action=").append(request.getParameter("action")); 
        //URL:login.jsp�ǹ�����;���demo�ǳ���login.jsp�ǿ��Թ������ʵģ�������URL���������ؿ���  
        if(url.toString().contains("/employee.do?action=login")){
        	return true;
        }  
        if(url.toString().contains("/employee.do?action=testEmpName")) {
        	return true;
        }
        
        
        //��ȡSession  
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
        //�����������ģ���ת����¼����  
        
        //TODO �����ص����� 
	    request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);  
	          
	    return false;  
        
    
	}

}
