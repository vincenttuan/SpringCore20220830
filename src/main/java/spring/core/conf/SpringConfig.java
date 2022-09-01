package spring.core.conf;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.core.session01.beans.Hello;
import spring.core.session01.beans.Lotto;
import spring.core.session01.beans.Lucky;
import spring.core.session02.beans.Author;
import spring.core.session02.beans.Book;

// Spring Java 配置, 可以用來取代 conf/applicationContext.xml 配置
// 宣告此類是一個配置定義
@Configuration
public class SpringConfig {
	
	// <bean id="hello" class="spring.core.session01.beans.Hello" />
	@Bean(name = "hello")
	@Scope(SCOPE_SINGLETON) // 預設就是 SCOPE_SINGLETON
	public Hello getHello() {
		Hello hello = new Hello();
		return hello;
	}
	
	@Bean(name = "lotto")
	public Lotto getLotto() {
		return new Lotto();
	}
	
	@Bean(name = "lotto2")
	public Lotto getLotto2() {
		return new Lotto();
	}
	
	@Bean(name = "lucky")
	@Scope(SCOPE_PROTOTYPE)
	public Lucky getLucky() {
		return new Lucky();
	}
	
	@Bean(name = "author")
	public Author getAuthor() {
		Author author = new Author("Vincent", 'M', 30);
		return author;
	}
	
	@Bean(name = "book")
	public Book getBook() {
		Book book = new Book();
		book.setName("Java");
		book.setPrice(500);
		book.setAuthor(getAuthor());
		return book;
	}
}
