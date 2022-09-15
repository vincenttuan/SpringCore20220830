package spring.core.session04;

import org.junit.Test;

import spring.core.session04.dyn.cglib.EnhancerHello;
import spring.core.session04.dyn.cglib.Hello;

public class EnhancerHelloTest {
	
	@Test
	public void test() {
		Hello hello = new Hello();
		System.out.println(hello.sayHello("John"));
		
		Hello hello2 = new EnhancerHello(); // 增強版
		System.out.println(hello2.sayHello("John"));
	}
	
}
