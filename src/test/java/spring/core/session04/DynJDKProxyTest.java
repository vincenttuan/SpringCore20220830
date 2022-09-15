package spring.core.session04;

import org.junit.Test;

import spring.core.session04.dyn.jdk.Calc;
import spring.core.session04.dyn.jdk.CalcImpl;
import spring.core.session04.dyn.jdk.DynJDKProxy;
import spring.core.session04.sta.proxy.Woman;
import spring.core.session04.sta.proxy.Man;
import spring.core.session04.sta.proxy.Person;

public class DynJDKProxyTest {
	
	@Test
	public void test() {
		// 未經過代理物件
		Calc calc = new CalcImpl();
		System.out.println(calc.add(10, 20));
		
		
		// 經過 JDK 動態代理
		Calc calc2 = (Calc)new DynJDKProxy(new CalcImpl()).getProxy();
		System.out.println(calc2.add(10, 20));
		
		Person person = (Person)new DynJDKProxy(new Woman()).getProxy();
		person.work();
		
		Person person2 = (Person)new DynJDKProxy(new Man()).getProxy();
		person2.work();
		
	}
	
}
