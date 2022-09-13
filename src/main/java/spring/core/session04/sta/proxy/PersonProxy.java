package spring.core.session04.sta.proxy;

// 靜態代理
// 代理執行任務(公用, 業務 etc...)
public class PersonProxy implements Person {
	// 代理對象
	private Person person;
	
	public PersonProxy(Person person) {
		this.person = person;
	}

	@Override
	public void work() {
		// before: 代理執行公用邏輯
		System.out.println("戴口罩");
		
		// 代理執行業務方法
		try {
			person.work();
		} catch(Exception e) {
			// exception: 例外的公用邏輯
			System.out.println("去買口罩");
		}
		
		// end: 代理執行公用邏輯
		System.out.println("脫口罩");
		
	}
}
