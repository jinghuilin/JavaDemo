package summer.web.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App {

	public static void main(String[] args) {
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("applicationContext.xml");
	    	 
	        //CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");
	        
	    	
	        //Customer customer1 = customerDao.getByCusId(1);
		//CustomerService customerService = (CustomerService) context.getBean("customerService");
	    //System.out.println(customerService.register(new Customer()));
	}

}
