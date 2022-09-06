package spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session03.beans.Teacher;

public class TestTeacher {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Teacher teacher1 = ctx.getBean("teacher1", Teacher.class);
		System.out.println(teacher1);
		// 請印出 teacher1 的學生名字與該生的總學分各是多少
		teacher1.getStudents()
				.stream()
				.forEach(stu -> {
					String name = stu.getName();
					int total = stu.getClazzs().stream().mapToInt(cla -> cla.getCredit()).sum();
					System.out.printf("學生姓名: %s 總學分: %d\n", name, total);
				});
		
	}
}
