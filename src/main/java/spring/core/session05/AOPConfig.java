package spring.core.session05;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 此為 Java 配置檔
@ComponentScan // 啟用元件掃描, 預設會掃描 AOPConfig.class 所在目錄與其子目錄的 java 程式檔
//@ComponentScan(basePackages = {"spring.core.session04", "spring.core.session05"}) // 自訂要掃描的目錄
public class AOPConfig {
	
}
