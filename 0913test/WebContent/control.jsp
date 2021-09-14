<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,model.msg.*,model.userTable.*"%>
<jsp:useBean id="mDAO" class="model.msg.MessageTableDAO" />
<jsp:useBean id="rDAO" class="model.msg.ReplyDAO"/>
<jsp:useBean id="uDAO" class="model.userTable.UserTableDAO" />
<jsp:useBean id="mVO" class="model.msg.MessageTableVO" />
<jsp:setProperty property="*" name="mVO" />
<jsp:useBean id="rVO" class="model.msg.ReplyVO" />
<jsp:setProperty property="*" name="rVO"/>
<jsp:useBean id="uVO" class="model.userTable.UserTableVO" />
<jsp:setProperty property="*" name="uVO"/>
<%
	String action = request.getParameter("action"); // action을 받아오고 지정
	String url="control.jsp?action=main"; // url을 지정
	String mcntt=request.getParameter("mcnt"); // mcnt를 받아옴
	int mcnt=0; // mcnt초기화작업
	if(mcntt!=null){
		mcnt=Integer.parseInt(mcntt);
	}
	url=url+"&mcnt="+mcnt;
	//System.out.println(mcnt+"체크1");
	String selUser=request.getParameter("selUser");
	if(selUser!=null){
		url=url+"&seluser="+selUser;
		
	}
	if (action.equals("main")) {
		ArrayList<MsgSet> datas = mDAO.selectAll(selUser, mcnt); // mDAO.selectAll 실행
		ArrayList<UserTableVO> newUsers=uDAO.selectAll();
		//System.out.println("체크");
		request.setAttribute("datas", datas); // datas값 넘겨주기
		//System.out.println(datas);	
		request.setAttribute("mcnt", mcnt); // mcnt값 넘겨주기
		//System.out.println(mcnt+"체크2");
		request.setAttribute("selUser", selUser);
		
		pageContext.forward("main.jsp");
	}
	
	else if(action.equals("login")){
		if(uDAO.login(uVO)){ // uDAO 실행 인작uVO
			session.setAttribute("selUser", uVO.getUserid()); //selUser에 UVO.getUserid 값 대입
			System.out.println(url);
			response.sendRedirect(url);
		}
		else{
			out.println("<script>alert('로그인 실패!');history.go(-1);</script>");
		}
	}
	else if(action.equals("logout")){
		session.invalidate();
		response.sendRedirect("control.jsp?action=main");
	}
	else if(action.equals("delete")){
		if(rDAO.delete(rVO)){
			System.out.println("확인");
			response.sendRedirect("control.jsp?action=main");
		}
	}
	else if(action.equals("writeMsg")){
		//System.out.println("1");
		if(mDAO.insert(mVO)){
			//System.out.println("write1");
			response.sendRedirect("control.jsp?action=main");
		}
	}
	else if(action.equals("writeReply")){
		System.out.println("2");
		if(rDAO.insert(rVO)){
			System.out.println("write2");
			response.sendRedirect("control.jsp?action=main");
		}
	}
%>