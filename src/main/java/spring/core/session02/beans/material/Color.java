package spring.core.session02.beans.material;

// 顏色
public class Color {
	
	private String name; // 顏色名

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Color [name=" + name + "]";
	}
	
}
