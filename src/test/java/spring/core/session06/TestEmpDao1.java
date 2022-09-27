package spring.core.session06;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session06.entity.Emp;
import spring.core.session06.template.EmpDao;

public class TestEmpDao1 {
	
	@Test
	public void test() {
		// 使用 xml 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		List<Map<String, Object>> emps = empDao.queryAll();
		System.out.println(emps);
		// 利用 java stream 來分析資料
		// 如何取得 eid = 2 的員工姓名 ?
		Optional<Map<String, Object>> optEmp = emps.stream()
				.filter(e -> (e.get("eid")+"").equals("2"))
				.findFirst();
		
		if(optEmp.isPresent()) {
			String ename = optEmp.get().get("ename") + "";
			System.out.println(ename);
		} else {
			System.out.println("查無此人");
		}
		
		
		
	}
	
}
