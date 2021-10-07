package com.kim.app.common;

import org.aspectj.lang.JoinPoint;

import model.member.MemberVO;

public class AfterReturningAdvice {
	public void printLog(JoinPoint jp,Object obj) {
		String name=jp.getSignature().getName();
		System.out.println("메서드명: "+name);
		if(obj instanceof MemberVO) {
			MemberVO data=(MemberVO)obj;
			if(data.getRole().equals("ADMIN")) {
				System.out.println("관리자 로그인");
			}
			else {
				System.out.println("일반사용자 로그인");
			}
		}
		System.out.println("get()와 조합되는 returning");
	}
}
