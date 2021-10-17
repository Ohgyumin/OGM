package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.client2.Client2VO;
import model.message2.Message2DAO;
import model.message2.Message2VO;

public class ListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ActionForward forward= new ActionForward();
		
		Message2DAO mDAO=new Message2DAO();
		
		
		String isMine = request.getParameter("isMine");
		ArrayList<Message2VO> datas=new ArrayList<Message2VO>();
		
		if(isMine == null) {
			datas = mDAO.getDBList(null);
		}
		else {
			datas = mDAO.getDBList((Client2VO)session.getAttribute("cVO"));
		}
		
	
		
		request.setAttribute("mdatas", datas);
		System.out.println(datas);
		forward.setRedirect(false);
		forward.setPath("list.jsp");
		return forward;
	}

}
