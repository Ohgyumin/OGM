package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.client.ClientDAO;
import model.client.ClientVO;

public class LogInAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = null;
		
		ClientDAO cDAO=new ClientDAO();
		ClientVO cVO=new ClientVO();
		
		cVO.setUserID(request.getParameter("userID"));
		cVO.setUserPW(request.getParameter("userPW"));
		
		cVO = cDAO.login(cVO); // ����
		if(cVO!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("seUser", cVO);
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("main.do");
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out=response.getWriter();
	        out.println("<script>alert('�α��� ����!');history.go(-1);</script>");
		}
		
		
		return forward;
	}

}
