package spring.core.session06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session06.entity.Emp;
import spring.core.session06.template.EmpDao;

public class TestEmpDao10_Delete {
	
	@Test
	public void test() {
		// 使用 xml 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		
		// 刪除 eid = 11 的紀錄
		int rowcount = empDao.deleteById(11);
		System.out.println(rowcount);
		if(rowcount == 0) {
			System.out.println("刪除失敗或無資料可供刪除");
		} else {
			System.out.println("刪除成功");
		}
				
		
		
		
	}
	
}
