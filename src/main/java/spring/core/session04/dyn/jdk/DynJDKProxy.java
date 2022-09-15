package spring.core.session04.dyn.jdk;

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
		
		return null;
	}
	
}
