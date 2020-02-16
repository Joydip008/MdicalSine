package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MyBean;
import dao.MyDao;

/**
 * Servlet implementation class Emergency1
 */
@WebServlet("/Emergency1")
public class Emergency1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Emergency1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i =0;
		PrintWriter out=response.getWriter();
		mb.setEPN(request.getParameter("EPN"));
		i=dao.InPatientDetails(mb);
		if(i>0) {
			//System.out.println("Data Insert Succesful:");
			out.print("Success");
			////////response.sendRedirect("PAGENAME.html");
			//RequestDispatcher rd=request.getRequestDispatcher("login.html");
			//rd.forward(request, response);
			
			
			HttpSession session=request.getSession();
			session.setAttribute("EPN", request.getParameter("EPN"));
			RequestDispatcher rd=request.getRequestDispatcher("Triage.jsp");
			rd.forward(request, response);
			
			
			
			//RequestDispatcher rd=request.getRequestDispatcher("Triage.jsp");
			//rd.forward(request, response);
		}
		else {
			out.print(" NotSuccess");
		}
	}

}
