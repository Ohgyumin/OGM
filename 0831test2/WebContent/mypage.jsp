<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.message.*,java.util.*"%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
		</tr>
		<%
			for (MessageVO vo : (ArrayList<MessageVO>) datas) {
		%>
		<tr>
			<td><a href="control.jsp?action=edit&m_id=<%=vo.getM_id()%>"><%=vo.getM_id()%></a></td>
			<!-- 글 변경을 위한 비밀번호 등의 인증작업처리 필요! -->
			<td><%=vo.getTitle()%></td>
			<td><%=vo.getContent()%></td>
			<td><%=vo.getWdate()%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>