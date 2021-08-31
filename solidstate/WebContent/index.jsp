<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.forward("control.jsp?action=list");
	// control.jsp에서 list 액션을 해줘!
	// 앞으로 index페이지는 control로 받게끔 직접 페이지이동X
%>
