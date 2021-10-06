package model.member2;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Member2Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		Member2Service ms=(Member2Service)factory.getBean("memberService");
		Member2VO vo=new Member2VO();
		vo.setId("su");
		vo.setPassword("1234");
		vo.setName("수");
		vo.setRole("관리자");
		ms.insertMember(vo);
		
		ArrayList<Member2VO> datas=ms.getMember(vo);
		for(Member2VO data:datas) {
			System.out.println(data);
		}
		factory.close();
	}
}
