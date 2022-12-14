package spring.core.session07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session07.tx.controller.BookController;
import spring.core.session07.tx.exception.InsufficientAmount;
import spring.core.session07.tx.exception.InsufficientQuantity;

public class TestManyBooks {
	
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		BookController bookController = ctx.getBean(BookController.class);
		try {
			// wid = 1, bids = 1, 1, 1
			bookController.buyManyBooks(1, 1, 1, 1);
		} catch (InsufficientAmount | InsufficientQuantity e) {
			System.out.println(e);
		}
		
	}
	
}
