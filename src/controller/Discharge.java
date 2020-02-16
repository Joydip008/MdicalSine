package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MyBean;
import dao.MyDao;

/**
 * Servlet implementation class Discharge
 */
@WebServlet("/Discharge")
public class Discharge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Discharge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int i=0,j=0,k=0,l=0;
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		mb.setId((String)session.getAttribute("Id"));
		mb.setFirstName((String)session.getAttribute("Id"));
		//mb.setStatus((String)session.getAttribute("Status"));
		mb.setRoomNum((String)session.getAttribute("RoomNum"));
		String AVA=(String)session.getAttribute("AVA");
		
		out.println((String)session.getAttribute("Id"));
		//out.print((String)session.getAttribute("Status"));
		out.println((String)session.getAttribute("RoomNum"));
		out.println((String)session.getAttribute("AVA"));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		//mb.setRD(dtf.format(localDate));
		mb.setDate1(dtf.format(localDate));
		
		int sum1=0,sum2=0;
		sum1=Integer.parseInt(AVA);
		//sum2=Integer.parseInt(AddStock);
		
		sum1=sum1+1;
		mb.setAVA(Integer.toString(sum1));
		
		i=dao.RoomUpdate(mb);
		j=dao.EPUPDATE(mb);
		k=dao.RegistrationPayment(mb);
		l=dao.Discharge(mb);
		if(i>0 && j>0 && k>0 && l>0) {
		//out.print("Updated");	
//		RequestDispatcher rd=request.getRequestDispatcher("viewProfile.jsp");
//		rd.forward(request, response);
			
			session.setAttribute("Id",(String)session.getAttribute("Id"));
			response.sendRedirect("Discharge.jsp");
		}
		else {
			out.print("not updated");
		}
	}

}
