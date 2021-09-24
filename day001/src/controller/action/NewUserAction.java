package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.userTable.UserTableDAO;
import model.userTable.UserTableVO;

public class NewUserAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		
		UserTableDAO uDAO=new UserTableDAO();
		UserTableVO uVO=new UserTableVO();
		uVO.setUserid(request.getParameter("userid"));
		uVO.setPasswd(request.getParameter("passwd"));
		uVO.setName(request.getParameter("name"));
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		if(uDAO.insert(uVO)){
			out.println("<script>alert('회원가입 성공! :D');window.close();</script>");
		}
		else{
			out.println("<script>alert('회원가입 실패!');history.go(-1);</script>");
		}
		
		return forward;
	}

}
