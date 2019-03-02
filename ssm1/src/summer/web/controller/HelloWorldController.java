package summer.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//1���ռ���������֤����  
		//2���󶨲������������  
		//3�������������ҵ��������ҵ����  
		//4��ѡ����һ��ҳ��  
		ModelAndView mv = new ModelAndView();  
		//���ģ������ �����������POJO����  
		mv.addObject("message", "Hello World!");  
		//�����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��  
		mv.setViewName("manager/hello");  
		return mv;  
	}

}
