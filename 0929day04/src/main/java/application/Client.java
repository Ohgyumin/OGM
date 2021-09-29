package application;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		
		// 1. 스프링 컨테이너 동작
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 객체 요청
		Pad pad=(Pad)factory.getBean("pad");
		pad.on();
		pad.use();
		pad.off();
		
		// 3. 스프링 컨테이너 종료
		factory.close();
	}
}
