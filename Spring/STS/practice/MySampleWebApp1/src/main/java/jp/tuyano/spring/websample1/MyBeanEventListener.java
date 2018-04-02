package jp.tuyano.spring.websample1;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;

public class MyBeanEventListener implements ApplicationListener<MyBeanEvent> {

	@Override
	public void onApplicationEvent(MyBeanEvent event) {
		System.out.println("MyBeanEvent is occured!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
	
}
