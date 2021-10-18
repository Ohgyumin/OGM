<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.board.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 메인화면</title>
</head>
<body>
<c:if test="${seUser!=null}">
	${seUser.userID}님, 환영합니다! <hr>
	<form action="logout.do" method="post" name="form2">

		<input type="submit" value="로그아웃">
	</form>
</c:if>
<h2>게시글</h2>
<hr>
<table>
	<tr>
		<th>글 번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>작성자</th>
		<th>작성일</th>
	</tr>
<c:if test="${mdatas==null}">
	<tr>
		<td colspan="5" align="center">등록된 게시글이 없습니다.</td>
	</tr>
</c:if>

<c:if test="${mdatas!=null}">
<c:forEach var="v" items="${mdatas}">
<tr>
	<td>${v.bnum}</td>
	<td>${v.title}</td>
	<td>${v.content}</td>
	<td>${v.userID}</td>
	<td>${v.wdate}</td>
</tr>
</c:forEach>
</c:if>

</table>
<a href="write.jsp">새 글 작성</a>	
</body>
</html>