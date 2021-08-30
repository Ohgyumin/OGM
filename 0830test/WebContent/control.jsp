<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.message.*" errorPage="error.jsp"%> <!-- java.util.*==ArrayList를 받기위해/model.message.*==MessageVO 제네릭을 위해 -->
<% request.setCharacterEncoding("UTF-8");%><!-- 한글을 받기위함 -->
<jsp:useBean id="messageDAO" class="model.message.MessageDAO"/>
<jsp:useBean id="messageVO" class="model.message.MessageVO"/>
<%
	// View들의 요청한 컨트롤러의 파라미터
	String action=request.getParameter("action"); // 액션을 요청받는다.
	System.out.println(action); // 무슨 액션을 실행했는지 확인
	
	if(action.equals("list")){ // list.jsp로 연결되는 액션
		ArrayList<MessageVO> datas=messageDAO.getDBList(); // MessageDAO.getDBList에 있는 message들을 ArrayList로 받기위해
		request.setAttribute("datas", datas);
		pageContext.forward("list.jsp"); // pageContext(jsp기본객체).forward 지정페이지(list.jsp)로 이동
	}
	else if(action.equals("update")){
		if(messageDAO.updateDB(messageVO)){
			response.sendRedirect("contro.jsp?action=list"); // 변경이 되었음
		}
		else{
			throw new Exception("DB 변경 오류발생"); // 변경이 안되어서 오류 페이지 실행
		}
	}
	else if(action.equals("edit")){ // edit.jsp로 연결되는 액션
		MessageVO data=messageDAO.getDBData(messageVO); // message하나 edit을 위해 select one
		request.setAttribute("data", data);
		pageContext.forward("edit.jsp");
	}
	else{
		out.println("파라미터 확인"); // 오타 혹은 없는 파라미터일때
	}
%>
