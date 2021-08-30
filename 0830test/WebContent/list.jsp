<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.message.*"%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request"/> <!-- control.jsp에서 받아오기에 scope는 request -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록 화면</title>
</head>
<body>
<h2>게시글 목록</h2>
<hr>
<a href="form.jsp">글 등록</a>
<hr>
<table border="1">
	<tr>
		<th>글 번호</th><th>제목</th><th>작성자</th><th>작성일</th>
	</tr>
	<%
		for(MessageVO vo:(ArrayList<MessageVO>)datas){ // for each문 글 목록 출력을 위함
	%>
		<tr>
			<td><a href="control.jsp?action=edit"><%=vo.getMnum()%></a></td>
			<td><%=vo.getTitle()%></td>
			<td><%=vo.getWriter()%></td>
			<td><%=vo.getWdate()%></td>
		</tr>
	<%		
		}
	%>
</table>
</body>
</html>