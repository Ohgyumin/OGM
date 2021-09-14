<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<hr>
<form action="control.jsp" method="post">
<c:choose>
	<c:when test="${empty selUser}">
		<input type="hidden" name="action" value="login">
		<input type="hidden" name="mcnt" value="${mcnt}">
		<input type="text" name="userid">
		<input type="password" name="passwd">
		<input type="submit" value="로그인">	
	</c:when>
	<c:otherwise>
		${selUser}님, 환영합니다!
		<input type="hidden" name="action" value="logout">
		<input type="submit" value="로그아웃">
		<%-- <a href="control.jsp?action=main&selUser=${selUser}">내글목록보기</a> --%>
	</c:otherwise>
</c:choose>
</form>
<h2>새글 작성</h2>
<c:if test="${selUser != null}">
	<form method="post" action="control.jsp" name="form1">
		<input type="hidden" name="action" value="writeMsg">
		<input type="hidden" name="userid" value="${selUser}">
		<input type="text" name="msg">
		<input type="submit" value="댓글 추가">
	</form>
</c:if>	
<hr>
<h2>전체목록</h2>
<hr>
<form action="control.jsp" method="post" name="form2">
<input type="hidden" name="action" value="writeReply">
<c:forEach var="v" items="${datas}">
	<c:set var="m" value="${v.m}"/>
	<h3>[$m.userid] ${m.msg} &gt;&gt; [좋아요 ${m.favcount} | 댓글 ${m.replycount} | ${m.datetime}]</h3>
	<c:forEach var="r" items="${v.rlist}">
		<a href="control.jsp?action=delete&rid=${r.rid}">${r.rid}</a> ${r.userid} >> ${r.rmsg} [${r.datetime}]
		<c:if test="${selUser != null}">
		<input type="hidden" name="userid" value="${selUser}">
		<input type="hidden" name="mid" value="${m.mid}">
		</c:if>
		<br>
	</c:forEach>
	<input type="text" name="rmsg">
	<input type="submit" value="댓글 추가">
</c:forEach>

</form>


<a href="control.jsp?action=main&mcnt=${mcnt+1}&selUser=${selUser}">더보기</a>
</body>
</html>