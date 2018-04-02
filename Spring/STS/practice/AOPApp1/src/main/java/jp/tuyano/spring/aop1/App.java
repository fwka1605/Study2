package jp.tuyano.spring.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private static ApplicationContext app;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		app = new ClassPathXmlApplicationContext("bean.xml");
		
		IMyBean<String> bean = (IMyBean<String>) app.getBean("bean1");

		bean.addData("Hello AOP World!");
		
		bean.addData("this is sample data.");
		
		System.out.println(bean);
	}

}
