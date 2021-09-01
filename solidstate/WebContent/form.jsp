<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<title>Elements - Solid State by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
<body class="is-preload">
<a href="control.jsp?action=list">메인으로 돌아가기</a>
<hr>
<form action="control.jsp" method="post" name="form1">
<input type="hidden" name="action" value="insert">
<table border="1">
   <tr>
      <td>작성자</td>
      <td><input type="text" name="writer"></td>
   </tr>
   <tr>
      <td>아이디</td>
      <td><input type="text" name="m_id"></td>
   </tr>
   <tr>
      <td>제목</td>
      <td><input type="text" name="title"></td>
   </tr>
   <tr>
      <td>내용</td>
      <td><input type="text" name="content"></td>
   </tr>
   <tr>
      <td colspan='2'><input type="submit" value="글 작성하기"></td>
   </tr>
</table>
</form>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
</div>
</body>
</html>