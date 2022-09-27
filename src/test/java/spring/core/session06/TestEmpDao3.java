package spring.core.session06;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session06.entity.Emp;
import spring.core.session06.template.EmpDao;

public class TestEmpDao3 {
	
	@Test
	public void test() {
		// 使用 xml 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		//List<Emp> emps = empDao.queryAll4();
		List<Emp> emps = empDao.queryAll5();
		// 想要印出每個員工有哪些工作 ?
		emps.forEach(e -> System.out.printf("name: %s jobs: %s\n", e.getEname(), e.getJobs()));
		
		
	}
	
}
