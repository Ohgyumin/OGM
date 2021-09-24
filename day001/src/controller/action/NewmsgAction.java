package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.MessageTableDAO;
import model.msg.MessageTableVO;

public class NewmsgAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		MessageTableDAO mDAO=new MessageTableDAO();
		MessageTableVO mVO=new MessageTableVO();
		mVO.setMsg(request.getParameter("msg"));
		mVO.setUserid(request.getParameter("userid"));
		System.out.println(mVO.getUserid()+"NewmsgID");
		if(!mDAO.insert(mVO)) {
			throw new IOException("newmsg에러 발생!");
		}
		
		forward.setRedirect(false);
		forward.setPath("main.do");
		return forward;
	}

}
