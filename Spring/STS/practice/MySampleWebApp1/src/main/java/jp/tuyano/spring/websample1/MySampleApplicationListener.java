package jp.tuyano.spring.websample1;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;

public class MySampleApplicationListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		
		if(event instanceof ContextRefreshedEvent) {
			System.out.println("refreshed!!!!!!!!!!!!!!!!!");
		}
		
		if(event instanceof ContextClosedEvent) {
			System.out.println("closed!!!!!!!!!!!!!!!!!");
		}
	}

}
