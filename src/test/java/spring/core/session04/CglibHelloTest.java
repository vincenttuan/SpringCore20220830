package spring.core.session04;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

import spring.core.session04.dyn.cglib.Hello;
import spring.core.session04.dyn.cglib.MyMethodIntercepter;

public class CglibHelloTest {
	
	@Test
	public void test() {
		// 使用 cglib 步驟
		// 1. 建立增強器
		Enhancer enhancer = new Enhancer();
		// 2. 要增強的對象
		enhancer.setSuperclass(Hello.class);
		// 3. 設置方法攔截器
		enhancer.setCallback(new MyMethodIntercepter());
		// 4. 運行
		Hello hello = (Hello)enhancer.create();
		System.out.println(hello.sayHello("John"));
		
	}
	
}
