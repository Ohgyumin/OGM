<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${empty seUser}">
	<form action="login.do" method="post">
		<input type="hidden" name="selUser" value="${selUser}">
		<input type="hidden" name="mcnt" value="${mcnt}">
		<input type="text" name="userid">
		<input type="password" name="passwd">
		<input type="submit" value="로그인">
	</form>
	</c:when>
	<c:otherwise>
		${seUser}님, 환영합니다!
		<a href="logout.do">로그아웃</a>
		<a href="main.do?mcnt=${mcnt}&selUser=${seUser}">내글목록보기</a>
		<a href="main.do?mcnt=${mcnt}">전체보기</a>
	</c:otherwise>
</c:choose>
