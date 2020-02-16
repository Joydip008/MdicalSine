package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MyBean;
import dao.MyDao;

/**
 * Servlet implementation class Present
 */
@WebServlet("/Present")
public class Present extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Present() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		//String RegId=request.getParameter("RegId");
		//String Name=request.getParameter("Name");
		//String Value=request.getParameter("Value");
		//out.print(RegId);
		//out.print(Name);
		//out.print(Value);
		int i=0;
		mb.setAId(request.getParameter("RegId"));
		//mb.setAName(request.getParameter("Name"));
		mb.setAttendence(request.getParameter("Value"));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate));
		
		mb.setADate(dtf.format(localDate));
		
		i=dao.Attendence(mb);
		if(i>0) {
			//System.out.println("Data Insert Succesful:");
			out.print("Success");
			////////response.sendRedirect("PAGENAME.html");
			//RequestDispatcher rd=request.getRequestDispatcher("login.html");
			//rd.forward(request, response);
			//RequestDispatcher rd=request.getRequestDispatcher("clickHere.html");
			//rd.forward(request, response);
		}
		else {
			out.print(" Not................Success");
		}
	}

}
