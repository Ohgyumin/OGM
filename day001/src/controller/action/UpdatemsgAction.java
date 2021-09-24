package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.MessageTableDAO;
import model.msg.MessageTableVO;

public class UpdatemsgAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		MessageTableDAO mDAO=new MessageTableDAO();
		MessageTableVO mVO=new MessageTableVO();
		mVO.setMid(Integer.parseInt(request.getParameter("mid")));
		mDAO.update(mVO);
		
		forward.setRedirect(false);
		forward.setPath("main.do");
		return forward;
	}

}
