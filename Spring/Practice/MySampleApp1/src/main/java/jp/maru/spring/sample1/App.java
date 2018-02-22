package jp.maru.spring.sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		/*
		System.out.println("Hello STS World");
		*/
		
		// 単純にBeanを利用したケース
		/*
		MyBean myBean = new MyBean("This is Bean sample!");
		System.out.println(myBean);
		*/
		
		// Bean構成ファイルを利用+インターフェイス
		/*
		ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
		MyBeanInterface myBean = (MyBeanInterface) app.getBean("mybean1");
		System.out.println(myBean);
		*/
		
		// AnnotationConfigApplicationContextによるBeanの利用
		/*
		ApplicationContext app = new AnnotationConfigApplicationContext(MyBean2.class);
		MyBeanInterface myBean =  app.getBean(MyBeanInterface.class);
		myBean.setMessage("annotation MyBean2");
		System.out.println(myBean);
		*/
		
		// Bean構成クラスを利用してのBeanの利用
		ApplicationContext app = new AnnotationConfigApplicationContext(AutoMyBeanConfig.class);
		MyBeanInterface myBean =  app.getBean(MyBeanInterface.class);
		myBean.setMessage("AutoMyBeanConfig MyBean");
		System.out.println(myBean);
		
		
	}

}
