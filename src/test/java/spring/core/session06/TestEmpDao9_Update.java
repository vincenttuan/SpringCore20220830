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
		
		// 取得 eid = 10 的 Emp 物件
		Emp emp = empDao.getEmpById(10);
		if(emp == null) {
			System.out.println("無此員工可以修改");
			return;
		}
		
		// 修改名字 = "M01", 年齡 = 23
		emp.setEname("M01");
		emp.setAge(23);
		
		int rowcount = empDao.updateEmp(emp);
		System.out.println(rowcount);
		
		
		
		
	}
	
}
