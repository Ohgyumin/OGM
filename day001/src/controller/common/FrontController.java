package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.DelmsgAction;
import controller.action.DelrpAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.MainAction;
import controller.action.NewUserAction;
import controller.action.NewmsgAction;
import controller.action.NewrpAction;
import controller.action.UpdatemsgAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) ������� ��û�� �м�
		String uri=request.getRequestURI();
		String cp=request.getContextPath();
		String action=uri.substring(cp.length());
		
		ActionForward forward=null;
		// 2) ��Ʈ�ѷ��� ����
		if(action.equals("/main.do")) {
			forward=new MainAction().execute(request, response);
		}
		else if(action.equals("/login.do")) {
			forward=new LoginAction().execute(request, response);
		}
		else if(action.equals("/logout.do")) {
			forward=new LogoutAction().execute(request, response);
		}
		else if(action.equals("/newrp.do")) {
			forward=new NewrpAction().execute(request, response);
		}
		else if(action.equals("/newUser.do")) {
			forward=new NewUserAction().execute(request, response);
		}
		else if(action.equals("/newmsg.do")) {
			forward=new NewmsgAction().execute(request, response);
		}
		else if(action.equals("/updatemsg.do")) {
			forward=new UpdatemsgAction().execute(request, response);
		}
		else if(action.equals("/delmsg.do")) {
			forward=new DelmsgAction().execute(request, response);
		}
		else if(action.equals("/delrp.do")) {
			forward=new DelrpAction().execute(request, response);
		}
		else {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/error404.jsp");
		}
		
		if(forward!=null) { 
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}
			else {
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}
