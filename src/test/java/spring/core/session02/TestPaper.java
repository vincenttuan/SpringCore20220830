package spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session02.beans.material.Paper;

public class TestPaper {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Paper paper = ctx.getBean("paper", Paper.class);
		System.out.println(paper);
		
		Paper paper2 = ctx.getBean("paper2", Paper.class);
		System.out.println(paper2);
		
	}
}
