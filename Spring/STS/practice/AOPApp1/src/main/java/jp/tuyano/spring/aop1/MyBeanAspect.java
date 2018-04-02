package jp.tuyano.spring.aop1;

import org.aspectj.lang.JoinPoint;

public class MyBeanAspect {

	public void addDataBefore(JoinPoint joinPoint) {
		System.out.println("*addData efore...*");
		
		String args = "args:\"";
		
		for(Object obj:joinPoint.getArgs()) {
			args += obj + "\" ";
		}
		
		System.out.println(args);
	}
}
