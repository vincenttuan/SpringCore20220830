package spring.core.session06;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session06.entity.Emp;
import spring.core.session06.entity.Job;
import spring.core.session06.template.EmpDao;

public class TestEmpDao6_Add {
	
	@Test
	public void test() {
		// 使用 xml 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		
		int rowcount1 = empDao.addOne1("X01", 30);
		System.out.println(rowcount1);
		
		int rowcount2 = empDao.addOne1("X02", 32);
		System.out.println(rowcount2);
		
		System.out.println("ADD OK");
	}
	
}
