package spring.core.session05.aop_lab;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect // 觀眾: 切面程式
public class Audience {
	
	@Pointcut(value = "execution(* spring.core.session05.aop_lab.Dancer.perform(..))")
	public void pt() {}
	
	@Before(value = "pt()")
	public void closeCellPhone() {
		System.out.println("前置通知: 觀眾-關手機");
	}
	
	@Before(value = "pt()")
	public void takeSeats() {
		System.out.println("前置通知: 觀眾-找座位");
	}
	
	@After(value = "pt()")
	public void exit() {
		System.out.println("後置通知: 觀眾-離場");
	}
	
	@AfterReturning(value = "pt()")
	public void applause() {
		System.out.println("返回通知: 觀眾-拍手鼓掌");
	}
	
	@AfterThrowing(value = "pt()")
	public void shhhhh() {
		System.out.println("例外通知: 觀眾-噓....");
	}
	
}
