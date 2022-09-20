package spring.core.session05.aop_lab;


public class Dancer implements Performance {

	@Override
	public void perform() {
		System.out.println("舞者表演開始");
		System.out.println("舞者動作: 轉圈, 翻滾 ...");
		System.out.println("舞者表演結束");
	}
	
}
