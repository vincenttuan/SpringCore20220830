package spring.core.session05.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // 可被 Spring 管理的元件
@Aspect // 切面程式
public class MyLoggerAspect {
	// 建立一個切入點的方法
	@Pointcut(value = "execution(* spring.core.session05.aop.MathCalcImpl.*(..))") 
	public void pt() {}
	
	@Pointcut(value = "execution(* spring.core.session05.aop.MathCalcImpl.div(..))") 
	public void pt2() {}
	
	// 前置通知 Advice : 執行連接點之前所要執行的程式
	//@Before(value = "execution(public Integer spring.core.session05.aop.MathCalcImpl.add(Integer, Integer))") // 切入點表達式 Spring EL : execution(..)
	//@Before(value = "execution(public Integer spring.core.session05.aop.MathCalcImpl.*(Integer, Integer))") // * 表示任意方法
	//@Before(value = "execution(public Integer spring.core.session05.aop.MathCalcImpl.*(..))") // .. 表示方法中有 0~n 個參數
	//@Before(value = "execution(* spring.core.session05.aop.MathCalcImpl.*(..))") // 第一個 * 表示任意修飾字與任意回傳型態
	//@Before(value = "execution(* spring.core.session05.aop.*.*(..))") // *.* 表示 任意類.任意方法
	//@Before(value = "execution(* *(..))") // 全部通通攔截
	@Before(value = "pt()")
	//@Before(value = "pt() && !pt2()") // 滿足 pt() 原則 AND(&&) 不滿足(!) pt2() 原則
	public void beforeAdvice(JoinPoint joinPoint) { // joinPoint 連接點
		String methodName = joinPoint.getSignature().getName();  // 取得方法簽章的名字
		Object[] args = joinPoint.getArgs(); // 方法參數
		System.out.printf("前置通知 - 方法名稱: %s 方法參數: %s\n", methodName, Arrays.toString(args));
	}
	
	@After(value = "pt()")
	public void afterAdvice(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();  // 取得方法簽章的名字
		System.out.printf("後置通知 - 方法名稱: %s\n", methodName);
	}
	
	
}
