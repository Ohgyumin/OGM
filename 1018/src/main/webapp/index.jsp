<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.board.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지 로그인 후 이용가능</title>
</head>
<body>

	<form action="login.do" method="post" name="form1">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userID"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userPW"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>
	<a href="signUp.jsp">회원가입</a>

</body>
</html>