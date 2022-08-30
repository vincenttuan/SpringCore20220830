package spring.core.session01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session01.beans.Lucky;

public class TestLucky {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		for(int i=0;i<10;i++) {
			Lucky lucky = ctx.getBean(Lucky.class);
			System.out.println(lucky);
		}
	}
}
