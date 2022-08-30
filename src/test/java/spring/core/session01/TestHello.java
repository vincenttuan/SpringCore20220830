package spring.core.session01;

import org.junit.Test;

import spring.core.session01.beans.Hello;

// 測試日期: 2022/08/30
// 測試人員: Vincent
public class TestHello {
	
	@Test
	public void test() {
		// 傳統上要先建立 Hello 物件才可以使用
		Hello h1 = new Hello();
		System.out.println(h1);
	}
	
}
