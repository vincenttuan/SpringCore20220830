package spring.core.session05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session05.aop.MathCalc;
import spring.core.session05.aop.MathCalcImpl;

public class MathCalcAOPTest {
	
	@Test
	public void test() {
		// XML 配置
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
		// Java 配置
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
		MathCalc calc = ctx.getBean("mathCalcImpl", MathCalc.class); // 不要寫成 MathCalcImpl.class
		System.out.println(calc.add(20, 10));
		System.out.println(calc.div(20, 10));
	}
	
}
