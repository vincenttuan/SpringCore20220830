package spring.core.session04.dyn.cglib;

// Enhancer 增強
// EnhancerHello 子類別具有增強 Hello 父類別的特性
public class EnhancerHello extends Hello {

	@Override // 覆寫 / 攔截的涵義(Intercepter)
	public String sayHello(String str) {
		String message = "請出示實聯 QRCode";
		return super.sayHello(str) + message;
	}
	
}
