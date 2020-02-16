package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
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
 * Servlet implementation class doctorRegistration
 */
@WebServlet("/doctorRegistration")
public class doctorRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doctorRegistration() {
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
		mb.setRegId(request.getParameter("RegId"));
		mb.setName(request.getParameter("Name"));
		mb.setDAge(request.getParameter("DAge"));
		mb.setQualification(request.getParameter("Qualification"));
		mb.setSpecialization(request.getParameter("Specialization"));
		mb.setExperience(request.getParameter("Experience"));
		mb.setArchievements(request.getParameter("Archievements"));
		mb.setHouseNo(request.getParameter("HouseNo"));
		mb.setStreet(request.getParameter("Street"));
		mb.setCity(request.getParameter("City"));
		mb.setState(request.getParameter("State"));
		mb.setCountry(request.getParameter("Country"));
		mb.setZipCode(request.getParameter("ZipCode"));
		mb.setPhoneWorkPlace(request.getParameter("PhoneWorkPlace"));
		mb.setPhoneResidence(request.getParameter("PhoneResidence"));
		mb.setDMobile(request.getParameter("DMobile"));
		mb.setEmailId(request.getParameter("EmailId"));
		mb.setAvaTime1(request.getParameter("AvaTime1"));
		mb.setAvaTime2(request.getParameter("AvaTime2"));
		mb.setAvaTime3(request.getParameter("AvaTime3"));
		mb.setFees(request.getParameter("Fees"));
		
		out.println(request.getParameter("DMobile"));  
		i=dao.doctorinsert(mb);
		if(i>0) {
			//System.out.println("Data Insert Succesful:");
			//out.print("Success");
			//response.sendRedirect("ViewAllDoctorByAdmin");
			RequestDispatcher rd=request.getRequestDispatcher("ViewAllDoctorByAdmin.jsp");
			rd.forward(request, response);
			//RequestDispatcher rd=request.getRequestDispatcher("clickHere.html");
			//rd.forward(request, response);
		}
		else {
			out.print(" Not................Success");
		}
	}
}
