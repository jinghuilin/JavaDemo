package summer.web.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggerAdvice {
	/**
	 * ִ��ǰ����ǿ����
	 * @param jp
	 */
	public void before(JoinPoint jp){
		System.out.println("ǰ����ǿ��ִ�С���ʼ����"+jp.getTarget()+"��"
				+jp.getSignature().getName()+"���������"+jp.getArgs());
	}
	
	/**
	 * ִ�к�����ǿ����
	 * @param jp
	 */
	public void afterReturning(JoinPoint jp){
		System.out.println("������ǿ��ִ�С���ɵ���"+jp.getTarget()+"��"
				+jp.getSignature().getName());
	}
	
	/**
	 * ִ���쳣�׳���ǿ����
	 * @param jp
	 */
	public void afterThrowing(JoinPoint jp){
		System.out.println("�쳣��ǿ����ִ��......");
	}
	
	/**
	 * ִ��������ǿ����
	 * @param jp
	 */
	public void after(JoinPoint jp){
		System.out.println("������ǿ����ִ��......");
	}
	
	/**
	 * ִ�л�����ǿ����
	 * @param pjp
	 * @throws Throwable
	 */
	public Object around(ProceedingJoinPoint pjp) throws Throwable  {
		Object returnValue=null;
		try {
			before(pjp);
			returnValue=pjp.proceed();
			afterReturning(pjp);
		} catch (Exception e) {
			afterThrowing(pjp);
		}finally{
			after(pjp);
		}
		return returnValue;
	}
}
