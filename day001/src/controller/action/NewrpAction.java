package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.ReplyDAO;
import model.msg.ReplyVO;

public class NewrpAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		ReplyDAO rDAO=new ReplyDAO();
		ReplyVO rVO=new ReplyVO();
		rVO.setMid(Integer.parseInt(request.getParameter("mid")));
		rVO.setRmsg(request.getParameter("rmsg"));
		rVO.setUserid(request.getParameter("userid"));
		if(!rDAO.insert(rVO)) {
			throw new IOException("newrp에러 발생!");
		}
		
		forward.setRedirect(false);
		forward.setPath("main.do");
		return forward;
	}

}
