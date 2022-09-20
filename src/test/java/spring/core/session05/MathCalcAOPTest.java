package spring.core.session05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session05.aop.MathCalc;

public class MathCalcAOPTest {
	
	@Test
	public void test() {
		// XML 配置
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
		// Java 配置
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
		MathCalc calc = ctx.getBean("mathCalcImpl", MathCalc.class); // 不要寫成 MathCalcImpl.class
		// 前置通知
		Integer result = calc.div(20, 0);
		// 後置通知
		// 返回通知 / 異常通知
		System.out.println("result = " + result);
		
	}
	
}
