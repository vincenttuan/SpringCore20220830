package spring.core.session06;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session06.template.EmpDao;

public class TestEmpDao11_Tx {
	
	@Test
	public void test() {
		// 使用 xml 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		
		// 新增 2 筆紀錄 (交易)
		int[] rowscount = empDao.addTwoTx("B01", 18, "B02", 19);
		if(rowscount != null) {
			System.out.println(Arrays.toString(rowscount));
		}
		
	}
	
}
