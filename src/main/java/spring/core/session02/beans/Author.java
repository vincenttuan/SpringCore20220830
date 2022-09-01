package spring.core.session02.beans;

public class Author {
	private String name;
	private Character sex;  // 使用 Character 代替 char
	private Integer age; // 使用 Integer 代替 int
	
	public Author() {
		
	}
	
	public Author(String name, Character sex, Integer age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getSex() {
		return sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
}
