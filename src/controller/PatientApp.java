package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MyBean;
import dao.MyDao;

/**
 * Servlet implementation class PatientApp
 */
@WebServlet("/PatientApp")
public class PatientApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientApp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i=0,j=0,k=0;
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		mb.setId(request.getParameter("Id"));
		mb.setBookingTime(request.getParameter("Time"));
		mb.setRegId(request.getParameter("RegId"));
		
	
		session.setAttribute("Time",request.getParameter("Time"));
		
		mb.setTo1(request.getParameter("Id"));
		mb.setFrom1(request.getParameter("RegId"));
		mb.setMsg(request.getParameter("Msg"));
		/*
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now(); 
		   String var=dtf.format(now);
		mb.setBookingTime(var);*/
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		//System.out.println(dtf.format(localDate));
		
		mb.setDate1(dtf.format(localDate));

		   //System.out.println(dtf.format(now));  
		i=dao.PatientApp(mb);
		j=dao.ChatInsert(mb);
		mb.setFirstName(request.getParameter("Id"));
		k=dao.RegistrationPayment(mb);
		if(i>0 && j>0 && k>0) {
			//System.out.println("Data Insert Succesful:");
			//out.print("Success");
			////////response.sendRedirect("PAGENAME.html");
			RequestDispatcher rd=request.getRequestDispatcher("SuccessfulAppBook.jsp");
			rd.forward(request, response);
			//RequestDispatcher rd=request.getRequestDispatcher("clickHere.html");
			//rd.forward(request, response);
		}
		else {
			out.print(" Not................Success");
		}
	}

}
