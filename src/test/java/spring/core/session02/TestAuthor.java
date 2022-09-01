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
		// 進行手動注入
		author1.setName("Vincent");
		author1.setSex('M');
		author1.setAge(30);
		System.out.println(author1);
		
		Author author2 = ctx.getBean("author2", Author.class);
		// author2 在配置檔中已經有預設注入資料(利用方法注入)
		System.out.println(author2);
		
		Author author3 = ctx.getBean("author3", Author.class);
		// author3 在配置檔中已經有預設注入資料(利用建構子注入)
		System.out.println(author3);
		
		Author author4 = ctx.getBean("author4", Author.class);
		// author4 在配置檔中已經有預設注入資料(利用 p 方法注入)
		System.out.println(author4);
		
		Author author5 = ctx.getBean("author5", Author.class);
		// author5 在配置檔中已經有預設注入資料(利用 c 建構子注入)
		System.out.println(author5);	
	}
}
