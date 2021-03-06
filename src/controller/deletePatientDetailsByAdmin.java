package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MyBean;
import dao.MyDao;

/**
 * Servlet implementation class deletePatientDetailsByAdmin
 */
@WebServlet("/deletePatientDetailsByAdmin")
public class deletePatientDetailsByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MyBean mb=new MyBean();
    MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletePatientDetailsByAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int i=0;
		PrintWriter out=response.getWriter();
		
		mb.setId(request.getParameter("Id"));
		
		i=dao.deletePatientDetailsByAdmin(mb);
		if(i>0) {
		//out.print("Deleted");	
			RequestDispatcher rd=request.getRequestDispatcher("viewAll.jsp");
			rd.forward(request, response);
		}
		else {
			out.print("not Deleted");
		}
	}

}
