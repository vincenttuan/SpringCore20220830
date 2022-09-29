package spring.core.session06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session06.entity.Emp;
import spring.core.session06.template.EmpDao;

public class TestEmpDao9_Update {
	
	@Test
	public void test() {
		// 使用 xml 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		
		List<Emp> emps = new ArrayList<>();
		// 放入 emp 物件
		emps.add(new Emp("Z01", 24));
		emps.add(new Emp("Z02", 25));
		emps.add(new Emp("Z03", 26));
		int[] rowcounts = empDao.batchAdd2(emps);
		System.out.println(Arrays.toString(rowcounts));
	}
	
}
