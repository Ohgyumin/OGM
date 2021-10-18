package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.LogInAction;
import controller.action.LogOutAction;
import controller.action.MainAction;
import controller.action.SignUpAction;
import controller.action.WriteAction;

/**
 * Servlet implementation class DispatcherServlet
 */
// @WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri= request.getRequestURI();
		String cp=request.getContextPath();
		String action = uri.substring(cp.length());
		
		ActionForward forward=null;
	
		if(action.equals("/main.do")) { // ���� 
			System.out.println("�����̵�");
			forward=new MainAction().execute(request, response);
		} 
		else if(action.equals("/login.do")) { // �α���
			System.out.println("�α���");
			forward=new LogInAction().execute(request, response);
		}
		else if(action.equals("/logout.do")) { // �α׾ƿ�
			System.out.println("�α׾ƿ�Ȯ��");
			forward=new LogOutAction().execute(request, response);
		}
		else if(action.equals("/write.do")) { // �Խñ� �߰�
			System.out.println("���ۼ�");
			forward=new WriteAction().execute(request, response); 
		}
		else if(action.equals("/signup.do")) { // ȸ������
			System.out.println("ȸ������");
			forward=new SignUpAction().execute(request, response);
		}
		
		else {
			 // ���� �������� ����
			forward=new ActionForward();
			forward.setRedirect(false);
			// ��κ� false �� �� . ������ � ������ ������ �м��� ���̱� ������?
			forward.setPath("/error/error404.jsp");
		}
		if (forward != null) { // ���� forward == null�̸� ���� �׼�ó���� ����� ���� ���� ��!
	         if (forward.isRedirect()) { // redirect ���
	            response.sendRedirect(forward.getPath());
	         } else { // forward ��� - ��û ����� �����Ͽ� ������ �̵�
	            // Dispatcher
	            // : Ŭ���̾�Ʈ�κ��� ���ʿ� ���� ��û�� JSP/Servlet ������ ���ϴ� �ڿ����� ��û�� �ѱ�� ������ �����ϰų�,
	            //   Ư�� �ڿ��� ó���� ��û�ϰ� ó�� ����� ������ ����� �����ϴ� Ŭ����
	            RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath()); // ���� ���
	            dispatcher.forward(request, response);
	         }
	      }
	}

}
