<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.message.*,model.member.*" errorPage="error.jsp"%><!-- java.util.*==ArrayList를 받기위해/model.message.*==MessageVO 제네릭을 위해 -->
<% request.setCharacterEncoding("UTF-8"); %><!-- 한글을 받기위함 -->
<jsp:useBean id="messageDAO" class="model.message.MessageDAO" />
<jsp:useBean id="messageVO" class="model.message.MessageVO" />
<jsp:useBean id="memDAO" class="model.member.MemberDAO" />
<jsp:useBean id="memVO" class="model.member.MemberVO" scope="session"/>
<jsp:setProperty property="*" name="messageVO"/> <!-- setter를 받기위함 -->
<jsp:setProperty property="*" name="memVO"/>
<%
	// 컨트롤러를 호출했을때의 요청 파라미터를 분석
	String action=request.getParameter("action"); // 액션을 요청받는다.
	//System.out.println(action);
	
	
	if(action.equals("login")){
		MemberVO mem=memDAO.selectOne(memVO);
		if(mem!=null){
			session.setAttribute("mem", mem);
			response.sendRedirect("control.jsp?action=list");
		}
		else{
			out.println("<script>alert('로그인 실패!');history.go(-1)</script>");
		}
	}
	else if(action.equals("list")){ // list.jsp로 연결되는 액션
		ArrayList<MessageVO> datas=messageDAO.getDBList(); // MessageDAO.getDBList에 있는 message들을 ArrayList로 받기위해
		request.setAttribute("datas", datas);
		pageContext.forward("list.jsp"); // pageContext(jsp기본객체).forward 지정페이지(list.jsp)로 이동
	}
	else if(action.equals("mypage")){
		ArrayList<MessageVO> datas=messageDAO.selectAll(memVO);
		request.setAttribute("datas", datas);
		pageContext.forward("list.jsp");
	}
	else if(action.equals("logout")){
		session.invalidate();
		pageContext.forward("index.jsp");
	}
	else if(action.equals("insert")){
		if(messageDAO.insertDB(messageVO)){
			response.sendRedirect("control.jsp?action=list");
		}
		
		else{
			throw new Exception("DB 추가 오류 발생!");// 변경이 안되면 오류 페이지 실행
		}
	}
	else if(action.equals("delete")){
		if(messageDAO.deleteDB(messageVO)){
			response.sendRedirect("control.jsp?action=list");
		}
		
		else{
			throw new Exception("DB 삭제 오류 발생!");
		}
	}
	else if(action.equals("update")){
		if(messageDAO.updateDB(messageVO)){
			response.sendRedirect("control.jsp?action=list");// 변경이 되었음
		}
		else{
			throw new Exception("DB 변경 오류 발생!");// 변경이 안되면 오류 페이지 실행
		}
	}
	else if(action.equals("edit")){ // edit.jsp로 연결되는 액션
			MessageVO data=messageDAO.getDBData(messageVO);
			request.setAttribute("data", data);
			pageContext.forward("edit.jsp");
			// 사용자가 잘못된 mnum를 건네는 경우는 없다!
			// -> 오류페이지로 처리!
	}
	else{
		out.println("<script>alert('파라미터 확인!');history.go(-1)</script>");
		//throw new Exception("파라미터 확인!");
	}
%>
    
    
    
    
    
    
    
    
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컨트롤러</title>
</head>
<body>

</body>
</html>