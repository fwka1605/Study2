package jp.tuyano.spring.websample1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="jp.tuyano.spring.websample1")
public class MyBeanConfig {

	@Bean
	public MyBean myBean() {
		return new MyBean();
	}
	
}
