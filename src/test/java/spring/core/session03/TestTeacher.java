package spring.core.session03;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session03.beans.Clazz;
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
		// 請印出 teacher2 所教授的課程名稱與學分數
		Teacher teacher2 = ctx.getBean("teacher2", Teacher.class);
		Clazz[] clazzs = {
				ctx.getBean("clazz1", Clazz.class),
				ctx.getBean("clazz2", Clazz.class),
				ctx.getBean("clazz3", Clazz.class)
		};
		teacher2.getSubjects()
				.forEach(name -> {
					Optional<Clazz> optClazz = Arrays.stream(clazzs)
									    .filter(cla -> cla.getName().equals(name))
									    .findFirst();
					//System.out.printf("科目: %s 學分: %s\n", name, optClazz.isPresent()?optClazz.get().getCredit():"None");
					System.out.printf("科目: %s 學分: %d\n", name, optClazz.isPresent()?optClazz.get().getCredit():0);
				});
		
	}
}
