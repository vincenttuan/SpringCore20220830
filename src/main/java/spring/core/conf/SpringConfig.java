package spring.core.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.core.session01.beans.Hello;

// Spring Java 配置, 可以用來取代 conf/applicationContext.xml 配置
// 宣告此類是一個配置定義
@Configuration
public class SpringConfig {
	
	// <bean id="hello" class="spring.core.session01.beans.Hello" />
	@Bean(name = "hello")
	public Hello getHello() {
		Hello hello = new Hello();
		return hello;
	}
	
}
