package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MyBean;
import dao.MyDao;

/**
 * Servlet implementation class Prescription
 */
@WebServlet("/Prescription")
public class Prescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prescription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i=0,j=0;
		PrintWriter out=response.getWriter();
	
		//String PID=request.getParameter("PID");
		//out.print(PID);
		
		mb.setPID(request.getParameter("PID"));
		out.print(request.getParameter("PID"));
		mb.setDrRegId(request.getParameter("DrRegId"));
		mb.setM1(request.getParameter("M1"));
		mb.setM2(request.getParameter("M2"));
		mb.setM3(request.getParameter("M3"));
		mb.setM4(request.getParameter("M4"));
		mb.setM5(request.getParameter("M5"));
		mb.setD1(request.getParameter("D1"));
		mb.setD2(request.getParameter("D2"));
		mb.setD3(request.getParameter("D3"));
		mb.setD4(request.getParameter("D4"));
		mb.setD5(request.getParameter("D5"));
		mb.setQ1(request.getParameter("Q1"));
		mb.setQ2(request.getParameter("Q2"));
		mb.setQ3(request.getParameter("Q3"));
		mb.setQ4(request.getParameter("Q4"));
		mb.setQ5(request.getParameter("Q5"));
		mb.setW1(request.getParameter("W1"));
		mb.setW2(request.getParameter("W2"));
		mb.setW3(request.getParameter("W3"));
		mb.setW4(request.getParameter("W4"));
		mb.setW5(request.getParameter("W5"));
		mb.setR1(request.getParameter("R1"));
		mb.setR2(request.getParameter("R2"));
		mb.setS1(request.getParameter("S1"));
		mb.setL1(request.getParameter("L1"));
		mb.setL2(request.getParameter("L2"));
		mb.setL3(request.getParameter("L3"));
		mb.setL4(request.getParameter("L4"));
		mb.setL5(request.getParameter("L5"));
		mb.setL6(request.getParameter("L6"));
		mb.setL7(request.getParameter("L7"));
		mb.setL8(request.getParameter("L8"));
		mb.setL9(request.getParameter("L9"));
		mb.setState(request.getParameter("Status"));
		String s=request.getParameter("Status");
		out.print(s);
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		mb.setPresDate(dtf.format(localDate));
		//System.out.println(dtf.format(localDate)); //2016/11/16
		
		i=dao.Prescription(mb);
		j=dao.PatientAppUpdateByDoctor(mb);
		
		if(i>0 && j>0) {
			//System.out.println("Data Insert Succesful:");
			//out.print("Success");
			//response.sendRedirect("ViewAllDoctorByAdmin");
			//mb.setStatus(request.getParameter("Status"));
			//i=dao.AppUpdate(mb);
			RequestDispatcher rd=request.getRequestDispatcher("SuccessfulSubmitPres.jsp");
			rd.forward(request, response);
			//RequestDispatcher rd=request.getRequestDispatcher("clickHere.html");
			//rd.forward(request, response);
		}
		else {
			out.print(" Not................Success");
		}
		
	}

}
