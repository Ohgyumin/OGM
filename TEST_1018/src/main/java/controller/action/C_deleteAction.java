package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.client2.Client2DAO;
import model.client2.Client2VO;

public class C_deleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		Client2DAO cDAO=new Client2DAO();
		Client2VO cVO= new Client2VO();
		System.out.println("userID :"+request.getParameter("userID"));
		cVO.setUserID(request.getParameter("userID"));
		if(!cDAO.delete(cVO)) { 
			throw new IOException("회원 탈퇴에서 발생!");
		}
		HttpSession session=request.getSession();
		session.invalidate();
		
		forward.setRedirect(true);
		forward.setPath("main.do"); 
		return forward;
	}

}
