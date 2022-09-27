package spring.core.session06;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session06.entity.Emp;
import spring.core.session06.template.EmpDao;

public class TestEmpDao2 {
	
	@Test
	public void test() {
		// 使用 xml 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		List<Emp> emps = empDao.queryAll2();
		// 印出 25 歲以上
		emps.stream()
			.filter(e -> e.getAge() > 25)
			.forEach(System.out::println);
		
		
	}
	
}
