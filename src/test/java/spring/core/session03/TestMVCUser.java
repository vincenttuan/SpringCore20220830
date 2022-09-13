package spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session03.mvc.model.User;

public class TestMVCUser {
	
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = ctx.getBean("user", User.class);
		System.out.println(user);
	}
	
}
