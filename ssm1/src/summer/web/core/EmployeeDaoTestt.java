package summer.web.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import summer.web.entity.Employee;
import summer.web.service.EmployeeService;



public class EmployeeDaoTestt {
	public static void main(String[] args) {
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("applicationContext.xml");
	    	 
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		Employee e = employeeService.login("slash", "123456");
		System.out.println(e);
	}
}
