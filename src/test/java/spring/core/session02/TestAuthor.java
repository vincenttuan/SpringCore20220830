package spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session02.beans.Author;

public class TestAuthor {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Author author1 = ctx.getBean("author1", Author.class);
		System.out.println(author1);
	}
}
