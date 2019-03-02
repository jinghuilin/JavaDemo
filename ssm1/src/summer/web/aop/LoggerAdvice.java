package summer.web.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggerAdvice {
	/**
	 * 执行前置增强处理
	 * @param jp
	 */
	public void before(JoinPoint jp){
		System.out.println("前置增强被执行。开始调用"+jp.getTarget()+"的"
				+jp.getSignature().getName()+"传入参数："+jp.getArgs());
	}
	
	/**
	 * 执行后置增强处理
	 * @param jp
	 */
	public void afterReturning(JoinPoint jp){
		System.out.println("后置增强被执行。完成调用"+jp.getTarget()+"的"
				+jp.getSignature().getName());
	}
	
	/**
	 * 执行异常抛出增强处理
	 * @param jp
	 */
	public void afterThrowing(JoinPoint jp){
		System.out.println("异常增强处理被执行......");
	}
	
	/**
	 * 执行最终增强处理
	 * @param jp
	 */
	public void after(JoinPoint jp){
		System.out.println("最终增强处理被执行......");
	}
	
	/**
	 * 执行环绕增强处理
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
