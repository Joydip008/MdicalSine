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
@WebServlet("/patientLogin")
public class patientLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public patientLogin() {
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
				mb.setId(request.getParameter("Id"));
				mb.setPassword(request.getParameter("Password"));
				
				
				String ID=request.getParameter("Id");
				String PASS=request.getParameter("Password");
				
				
				String data[]=null;
				
				data=dao.login(mb);
				
				if(data[0].equals(ID) && data[1].equals(PASS)) {
					//out.print("LOGIN SUCESSSFULL");
					
					
					HttpSession session=request.getSession();
					session.setAttribute("Id", data[0]);
					session.setAttribute("Password", data[1]);
					RequestDispatcher rd=request.getRequestDispatcher("PDDD.jsp");
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
