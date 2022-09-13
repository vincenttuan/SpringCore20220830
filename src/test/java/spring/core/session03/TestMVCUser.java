package spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session03.mvc.controller.UserController;
import spring.core.session03.mvc.model.User;

public class TestMVCUser {
	
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user1 = ctx.getBean("user", User.class);
		User user2 = ctx.getBean("user", User.class);
		user2.setUsername("Mary");
		user2.setAge(20);
		System.out.println("user 物件資料");
		System.out.println(user1);
		System.out.println(user2);
		
		// 將 user 加入到資料庫中
		System.out.println("\n將 user 加入到資料庫中");
		UserController userController = ctx.getBean("userController", UserController.class);
		userController.insert(user1);
		userController.insert(user2);
		
		// 查詢 user 資料
		System.out.println("\n查詢 user 資料");
		System.out.println(userController.selectAll());
	}
	
}
