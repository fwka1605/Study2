package jp.maru.spring.sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		// Bean構成ファイルを利用
		ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
		MyBean myBean = (MyBean) app.getBean("mybean1");
		System.out.println(myBean);
	}

}
