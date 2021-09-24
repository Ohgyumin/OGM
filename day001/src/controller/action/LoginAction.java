package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.msg.MessageTableDAO;
import model.msg.MsgSet;
import model.userTable.UserTableDAO;
import model.userTable.UserTableVO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		
		UserTableDAO uDAO=new UserTableDAO();
		UserTableVO uVO=new UserTableVO();
		uVO.setUserid(request.getParameter("userid"));
		uVO.setPasswd(request.getParameter("passwd"));
				
		if(uDAO.login(uVO)) {
			HttpSession session=request.getSession();
			session.setAttribute("seUser", uVO.getUserid());
			System.out.println(session.getAttribute("seUser")+"로그인ID");
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
			
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>alert('회원가입 실패!');history.go(-1);</script>");
		}
		
		return forward;
	}

}
