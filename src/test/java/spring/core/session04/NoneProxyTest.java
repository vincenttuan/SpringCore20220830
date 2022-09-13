package spring.core.session04;

import org.junit.Test;

import spring.core.session04.sta.none.Man;
import spring.core.session04.sta.none.Person;
import spring.core.session04.sta.none.Woman;

public class NoneProxyTest {
	
	@Test
	public void test() {
		// 不透過代理直接執行
		Person man = new Man();
		Person woman = new Woman();
		man.work();
		woman.work();
		
	}
}
