package spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session02.beans.Book;

public class TestBook {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Book book1 = ctx.getBean("book1", Book.class);
		System.out.println(book1);
		
		Book book2 = ctx.getBean("book2", Book.class);
		System.out.println(book2);
	}
}
