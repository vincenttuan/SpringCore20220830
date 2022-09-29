package spring.core.session06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session06.template.EmpDao;

public class TestEmpDao7_BatchAdd {
	
	@Test
	public void test() {
		// 使用 xml 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		
		List<Object[]> rows = new ArrayList<>();
		// 放入 ename, age
		rows.add(new Object[] {"Y01", 41});
		rows.add(new Object[] {"Y02", 42});
		rows.add(new Object[] {"Y03", 43});
		int[] rowcounts = empDao.batchAdd1(rows);
		System.out.println(Arrays.toString(rowcounts));
	}
	
}
