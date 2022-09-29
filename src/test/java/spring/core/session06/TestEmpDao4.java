package spring.core.session06;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session06.entity.Emp;
import spring.core.session06.entity.Job;
import spring.core.session06.template.EmpDao;

public class TestEmpDao4 {
	
	@Test
	public void test() {
		// 使用 xml 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		List<Job> emps = empDao.queryJobs();
		// 想要印出每個工作交給哪一個員工 ?
		emps.forEach(j -> System.out.printf("job name: %s emp name: %s\n", 
				j.getJname(), 
				j.getEmp().getEname() == null ? "" : j.getEmp().getEname()));
		
		
		
	}
	
}
