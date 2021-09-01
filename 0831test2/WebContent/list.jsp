<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.message.*,java.util.*"%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="memVO" class="model.member.MemberVO" scope="session"/>
<jsp:setProperty property="*" name="memVO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록 화면</title>
<script type="text/javascript">
	function next(){
		document.form2.action.value="mypage";
		document.form2.submit();
	}
	function previous(){
		document.form2.action.value="list";
		document.form2.submit();
	}
</script>
</head>
<body>

	<h2>게시글 목록</h2>
	<hr>

	<%
		if (session.getAttribute("mem") == null) {
	%>
	<form action="control.jsp" method="post" name="form1">
		<input type="hidden" name="action" value="login">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="mid"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="mpw"></td>
			</tr>
			<tr>
				<td colspan='2'><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>

	<%
		} else {
	%>
	<form action="control.jsp" method="post" name="form2">
		<input type="hidden" name="action" value="logout">
		 <input type="submit" value="로그아웃">
		 <input type="button" onClick="previous()" value="전체 글보기"> 
		 <input type="button" onClick="next()" value="내 글보기">
	</form>
	<%
		}
	%>
	<hr>
	<a href="form.jsp">글 등록</a>
	<hr>
	<table border="1">
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<%
			for (MessageVO vo : (ArrayList<MessageVO>) datas) {
		%>
		<tr>
			<td><a href="control.jsp?action=edit&mnum=<%=vo.getMnum()%>"><%=vo.getMnum()%></a></td>
			<!-- 글 변경을 위한 비밀번호 등의 인증작업처리 필요! -->
			<td><%=vo.getTitle()%></td>
			<td><%=vo.getM_id()%></td>
			<td><%=vo.getWriter()%></td>
			<td><%=vo.getWdate()%></td>
		</tr>
		<%
			}
		%>
	</table>


</body>
</html>