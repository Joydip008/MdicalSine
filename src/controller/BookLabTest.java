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
 * Servlet implementation class BookLabTest
 */
@WebServlet("/BookLabTest")
public class BookLabTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookLabTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i=0;
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		mb.setId((String)session.getAttribute("Id"));
		mb.setRegId((String)session.getAttribute("RegId"));
		mb.setPresNum((String)session.getAttribute("PN"));
		i=dao.BookLabTest(mb);
		if(i>0) {
			//System.out.println("Data Insert Successful:");
			//out.print("Success");
			////////response.sendRedirect("PAGENAME.html");
			RequestDispatcher rd=request.getRequestDispatcher("SuccessfulLabTestBook.jsp");
			rd.forward(request, response);
			//RequestDispatcher rd=request.getRequestDispatcher("clickHere.html");
			//rd.forward(request, response);
		}
		else {
			out.print(" NotSuccess");
		}
	}

}
