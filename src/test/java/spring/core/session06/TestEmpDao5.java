package spring.core.session06;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session06.entity.Emp;
import spring.core.session06.entity.Job;
import spring.core.session06.template.EmpDao;

public class TestEmpDao5 {
	
	@Test
	public void test() {
		// 使用 xml 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		Emp emp = empDao.getEmpById(1, true); // (1) or (1, false) or (1, true)
		System.out.println(emp);
		Job job = empDao.getJobById(1, true);
		System.out.println(job);
		
	}
	
}
