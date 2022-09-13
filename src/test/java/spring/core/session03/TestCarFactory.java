package spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session03.beans.Car;

public class TestCarFactory {
	
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 對 carFactory 要二了台車
		Car car1 = ctx.getBean("carFactory", Car.class);
		Car car2 = ctx.getBean("carFactory", Car.class);
		System.out.println(car1);
		System.out.println(car2);
	}
	
}
