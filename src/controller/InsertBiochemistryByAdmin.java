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
 * Servlet implementation class InsertBiochemistryByAdmin
 */
@WebServlet("/InsertBiochemistryByAdmin")
public class InsertBiochemistryByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MyBean mb=new MyBean();
    MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBiochemistryByAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i=0;
		PrintWriter out=response.getWriter();
		mb.setTestName(request.getParameter("TestName"));
		mb.setNormalRate(request.getParameter("NormalRate"));
		mb.setTPrice(request.getParameter("TPrice"));
		
		//out.println("HELLO");  
		i=dao.InsertBiochemistryByAdmin(mb);
		if(i>0) {
			//System.out.println("Data Insert Succesful:");
			//out.print("Success");
			//response.sendRedirect("ViewAllDoctorByAdmin");
			RequestDispatcher rd=request.getRequestDispatcher("Biochemistry.jsp");
			rd.forward(request, response);
			//RequestDispatcher rd=request.getRequestDispatcher("clickHere.html");
			//rd.forward(request, response);
		}
		else {
			out.print(" Not................Success");
		}
	}

}
