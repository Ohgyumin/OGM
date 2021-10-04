package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
	
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		Champ champ=(Champ)factory.getBean("champ");
		champ.attack();
		//champ.print();
		// NoSuchBeanDefinitionException : 이름이 정의되지않는 애 호출
		
		factory.close();
	}
}
