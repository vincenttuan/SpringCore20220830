package spring.core.session03;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session03.beans.Student;

public class TestStudent {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student1 = ctx.getBean("student1", Student.class);
		Student student2 = ctx.getBean("student2", Student.class);
		Student[] students = {student1, student2};
		Arrays.stream(students).forEach(System.out::println);
		// 每一個學生修了幾學分
		// student1 修了幾學分 ?
		int student1_credit = student1.getClazzs().stream().mapToInt(cla -> cla.getCredit()).sum();
		System.out.printf("student1 修了 %d 學分\n", student1_credit);
		// student2 修了幾學分 ?
		int student2_credit = student2.getClazzs().stream().mapToInt(cla-> cla.getCredit()).sum();
		System.out.printf("student2 修了 %d 學分\n", student2_credit);		
		// 學生們總共修了幾學分 ?
		int total = Arrays.stream(students)
				.mapToInt(stu -> stu.getClazzs().stream().mapToInt(cla -> cla.getCredit()).sum() )
				.sum();
		System.out.printf("學生們總共修了 %d 學分\n", total);
	}
}
