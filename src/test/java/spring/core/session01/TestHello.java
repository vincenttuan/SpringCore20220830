package spring.core.session01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.conf.SpringConfig;
import spring.core.session01.beans.Hello;

// 測試日期: 2022/08/30
// 測試人員: Vincent
public class TestHello {
	
	@Test
	public void test() {
		// 傳統上要先建立 Hello 物件才可以使用
		Hello h1 = new Hello();
		System.out.println(h1);
		
		// 利用 Spring 來取得所管理的 Hello 物件
		// xml 定義檔: conf/applicationContext.xml
		// ApplicationContext 應用程式環境=Spring環境
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 只有在定義一個 Hello <bean> 的配置下才可以使用
		Hello h2 = ctx.getBean(Hello.class);
		System.out.println(h2);
		
		Hello h3 = ctx.getBean("hello", Hello.class);
		System.out.println(h3);
		
		// Java 配置: spring.core.conf.SpringConfig.java
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext(SpringConfig.class);
		Hello h4 = ctx2.getBean(Hello.class);
		Hello h5 = ctx2.getBean("hello", Hello.class);
		System.out.println(h4);
		System.out.println(h5);
	}
	
}
