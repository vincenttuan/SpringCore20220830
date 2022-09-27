package spring.core.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

// Spring jdbc - Java 配置 (可以取代傳統的 jdbc-config.xml 配置檔)
@Configuration // 告知 Spring 說此類是一個配置檔
@ComponentScan(basePackages = {"spring.core.session06", "spring.core.session07"})
@PropertySource(value = {"classpath:db.properties"}, ignoreResourceNotFound = true)
@EnableTransactionManagement // 啟動交易管理
public class SpringJdbcConfig {
	
	@Autowired
	private Environment env; // 透過 env 可以取得外部資源配置檔(如: db.properties)
	
	@Bean
	public DataSource dataSpurce() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {
			// basic
			ds.setDriverClass(env.getProperty("jdbc.driver"));
			ds.setJdbcUrl(env.getProperty("jdbc.url"));
			ds.setUser(env.getProperty("jdbc.username"));
			ds.setPassword(env.getProperty("jdbc.password"));
			
			// options
			ds.setMinPoolSize(10);
			ds.setMaxPoolSize(100);
			ds.setInitialPoolSize(180); // 秒
			ds.setMaxStatements(100);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ds;
	}
	
}
