package spring.core.session04.dyn.jdk;

import java.lang.reflect.Method;
import java.util.Arrays;

// MyLogger 就是公用邏輯(也就是切面程式: Aspect)
public class MyLogger {
	// Before: 前置通知(在執行業務方法前所要執行的程式) - Advice(具體的實作)
	public static void before(Method method, Object[] args) {
		System.out.printf("Before: 前置通知: %s 方法準備開始計算, 方法參數: %s\n", method.getName(), Arrays.toString(args));
	}
	
	// Exception: 例外異常通知(在執行業務方法時生例外所要執行的程式) - Advice(具體的實作)
	public static void throwing(Method method, Exception e) {
		System.out.printf("Exception: 例外異常通知: %s 方法發生例外, 訊息: %s\n", method.getName(), e);
	}
	
	// End: 後置通知(在執行業務方法完畢後所要執行的程式) - Advice(具體的實作)
	public static void end(Method method) {
		System.out.printf("End: 後置通知: %s 方法計算完成\n", method.getName());
	}
}
