package spring.core.session05.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component // 可被 Spring 管理的元件
@Aspect // 切面程式
public class MyLoggerAspect {
	
	// 前置通知 Advice : 執行連接點之前所要執行的程式
	@Before(value = "execution(public spring.core.session05.aop.MathCalcImpl.add(Integer, Integer))")
	public void beforeAdvice(JoinPoint joinPoint) { // joinPoint 連接點
		String methodName = joinPoint.getSignature().getName();  // 取得方法簽章的名字
		Object[] args = joinPoint.getArgs(); // 方法參數
		System.out.printf("前置通知 - 方法名稱: %s 方法參數: %s\n", methodName, args);
	}
	
}
