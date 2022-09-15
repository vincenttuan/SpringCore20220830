package spring.core.session04;

import org.junit.Test;

import spring.core.session04.dyn.jdk.Calc;
import spring.core.session04.dyn.jdk.CalcImpl;

public class DynJDKProxyTest {
	
	@Test
	public void test() {
		// 未經過代理物件
		Calc calc = new CalcImpl();
		System.out.println(calc.add(10, 20));
	}
	
}
