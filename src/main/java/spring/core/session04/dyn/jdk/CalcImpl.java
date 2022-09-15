package spring.core.session04.dyn.jdk;

public class CalcImpl implements Calc {

	@Override
	public int add(int x, int y) {
		// log 紀錄
		// System.out.printf("Log: x = %d, y= %d\n", x,  y);
		// 不要將上述與商業邏輯無關的資料放入
		
		// 商業邏輯
		int result = x + y;
		return result;
	}

	@Override
	public int div(int x, int y) {
		// log 紀錄
		// System.out.printf("Log: x = %d, y= %d\n", x,  y);
		// 不要將上述與商業邏輯無關的資料放入
		
		// 商業邏輯
		int result = x / y;
		return result;
	}
	
}
