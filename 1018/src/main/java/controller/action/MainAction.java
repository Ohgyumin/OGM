package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;
import model.client.ClientVO;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ActionForward forward= new ActionForward();
		
		BoardDAO bDAO=new BoardDAO();
		ClientVO cVO = null;
		
		ArrayList<BoardVO> datas=new ArrayList<BoardVO>();
	
		datas = bDAO.getDBList(cVO);
	
		
		request.setAttribute("mdatas", datas);
				
		forward.setRedirect(false);
		forward.setPath("main.jsp");
		return forward;
	}

}
