package spring.core.session04.dyn.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

// JDK 版動態代理(for all)
public class DynJDKProxy {
	// 代理的物件
	private Object object;
	
	// 建構子注入要代理的物件實體
	public DynJDKProxy(Object object) {
		this.object = object;
	}
	
	// 取得代理物件
	public Object getProxy() {
		Object proxyObj = null;
		// 1. 類別載入器
		ClassLoader loader = object.getClass().getClassLoader();
		// 2. 代理物件所實作的介面
		Class[] interfaces = object.getClass().getInterfaces();
		// 3. 處理代理的實現
		// invoke(Object proxy, Method method, Object[] args)
		InvocationHandler invocationHandler = (proxy, method, args) -> {
			Object result = null;
			// Before: 前置通知
			System.out.printf("Before: 前置通知: %s 方法準備開始計算, 方法參數: %s\n", method.getName(), Arrays.toString(args));
			// 執行代理物件的商業方法
			result = method.invoke(object, args);
			
			return result;
		};
		
		// 得到代理物件的實體
		proxyObj = Proxy.newProxyInstance(loader, interfaces, invocationHandler);
		return proxyObj;
	}
	
}
