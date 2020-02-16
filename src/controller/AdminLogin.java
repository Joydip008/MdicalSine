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
 * Servlet implementation class patientLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//mb.setEmpId(request.getParameter("EmpId"));
				PrintWriter out=response.getWriter();
				mb.setAdminId(request.getParameter("AdminId"));
				mb.setAdminPassword(request.getParameter("AdminPassword"));
				
				
				String ADMINID=request.getParameter("AdminId");
				String ADMINPASS=request.getParameter("AdminPassword");
				
				
				String data[]=null;
				
				data=dao.AdminLogin(mb);
				
				out.println(ADMINID);
				out.println(ADMINPASS);
				out.print("Hello");
				//out.println(data[0]);
				//out.println(data[1]);
				
				if(data[0].equals(ADMINID) && data[1].equals(ADMINPASS)) {
					//out.print("LOGIN SUCESSSFULL");
					
					
					HttpSession session=request.getSession();
					session.setAttribute("AdminId", data[0]);
					//session.setAttribute("Password", data[1]);
					RequestDispatcher rd=request.getRequestDispatcher("ADDD.jsp");
					rd.forward(request, response);
					//response.sendRedirect("sessionController.java");
					
					
					//RequestDispatcher rd=request.getRequestDispatcher("viewProfile.jsp");
					//rd.forward(request, response);
					//RequestDispatcher rd=request.getRequestDispatcher("viewProfile.jsp");
					//rd.forward(request, response);
					
				}
				else {
					out.print("Failure");
				}
				
			}
}
