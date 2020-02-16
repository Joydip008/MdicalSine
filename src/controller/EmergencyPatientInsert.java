package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class EmergencyPatientInsert
 */
@WebServlet("/EmergencyPatientInsert")
public class EmergencyPatientInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmergencyPatientInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i=0,j=0;
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		mb.setName(request.getParameter("Name"));
		mb.setRegId(request.getParameter("DID"));
		mb.setAge(request.getParameter("Age"));
		mb.setAddress(request.getParameter("Addr"));
		mb.setMobile(request.getParameter("Mobile1"));
		mb.setPhoNo(request.getParameter("Mobile2"));
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		//System.out.println(sdf.format(date));
		mb.setTime(sdf.format(date));
		
		mb.setRoomNum((String)session.getAttribute("NUM"));
		String AVA=(String)session.getAttribute("AVA");
		
		int sum1=0,sum2=0;
		sum1=Integer.parseInt(AVA);
		//sum2=Integer.parseInt(AddStock);
		
		sum1=sum1-1;
		mb.setAVA(Integer.toString(sum1));
		
		
		
		i=dao.EPINSERT(mb);
		j=dao.RoomAllo(mb);
		if(i>0 && j>0) {
			//System.out.println("Data Insert Succesful:");
			//out.print("Success");
			//response.sendRedirect("ViewAllDoctorByAdmin");
			session.setAttribute("Time",sdf.format(date));
			RequestDispatcher rd=request.getRequestDispatcher("SuccessfulEPREG.jsp");
			rd.forward(request, response);
			//RequestDispatcher rd=request.getRequestDispatcher("clickHere.html");
			//rd.forward(request, response);
		}
		else {
			out.print(" Not................Success");
		}
	}

}
