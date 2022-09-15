package spring.core.session03.mvc.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // 是一個可以被 Spring 來管理的物件
@Scope("prototype")
@PropertySource("classpath:user.properties")
public class User { // 使用者資料模型
	
	@Value(value = "John") // 配置預設值 John
	//@Value("${user.username}")
	private String username; // 姓名
	
	//@Value(value = "18")
	@Value("${user.age}")
	private Integer age; // 年齡
	
	@Value(value = "#{${nicknames: {'foo', 'bar'}}}") // 使用 Spring EL
	//@Value("${user.nicknames}")
	private String[] nicknames; // 暱稱
	
	@Value(value = "#{${subjects: {'Java', 'Python'}}}")
	//@Value("${user.subjects}")
	private Set<String> subjects; // 專長科目
	
	@Value(value = "#{${scores: {100, 90}}}")
	//@Value("#{'${user.scores}'.split(',')}")
	private List<Integer> scores; // 各科成績
	
	@Value(value = "#{${hobbies: {'h1': 'Program', 'h2': 'Game'}}}")
	//@Value("${user.hobbies}")
	private Map<String, String> hobbies; // 興趣
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String[] getNicknames() {
		return nicknames;
	}
	public void setNicknames(String[] nicknames) {
		this.nicknames = nicknames;
	}
	public Set<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}
	public List<Integer> getScores() {
		return scores;
	}
	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
	public Map<String, String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(Map<String, String> hobbies) {
		this.hobbies = hobbies;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + ", nicknames=" + Arrays.toString(nicknames)
				+ ", subjects=" + subjects + ", scores=" + scores + ", hobbies=" + hobbies + "]";
	}
	
	
	
}
