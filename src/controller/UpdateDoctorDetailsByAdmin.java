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
 * Servlet implementation class UpdateDoctorDetailsByAdmin
 */
@WebServlet("/UpdateDoctorDetailsByAdmin")
public class UpdateDoctorDetailsByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDoctorDetailsByAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		mb.setPhoneWorkPlace(request.getParameter("PhoneWrokPlace"));
		mb.setPhoneResidence(request.getParameter("PhoneResidence"));
		mb.setDMobile(request.getParameter("DMobile"));
		mb.setEmailId(request.getParameter("EmailId"));
		mb.setAvaTime1(request.getParameter("AvaTime1"));
		mb.setAvaTime2(request.getParameter("AvaTime2"));
		mb.setAvaTime3(request.getParameter("AvaTime3"));
		mb.setFees(request.getParameter("Fees"));

		out.println(request.getParameter("RegId"));
		out.println(request.getParameter("Name"));
		out.println(request.getParameter("DAge"));
		out.println(request.getParameter("Qualification"));
		out.println(request.getParameter("Specialization"));
		out.println(request.getParameter("Experience"));
		out.println(request.getParameter("Archievements"));
		out.println(request.getParameter("HouseNo"));
		out.println(request.getParameter("Street"));
		out.println(request.getParameter("City"));
		out.println(request.getParameter("State"));
		out.println(request.getParameter("Country"));
		out.println(request.getParameter("ZipCode"));
		out.println(request.getParameter("PhoneWrokPlace"));
		out.println(request.getParameter("PhoneResidence"));
		out.println(request.getParameter("DMobile"));
		out.println(request.getParameter("Fax"));
		out.println(request.getParameter("EmailId"));
		out.println(request.getParameter("AvaTime1"));
		out.println(request.getParameter("AvaTime2"));
		out.println(request.getParameter("AvaTime3"));
		out.println(request.getParameter("Fees"));
		i=dao.UpdateDoctorDetailsByAdmin(mb);
		if(i>0) {
			//out.print("Updated");	
			RequestDispatcher rd=request.getRequestDispatcher("ViewAllDoctorByAdmin.jsp");
			rd.forward(request, response);
			}
			else {
				out.print("not updated");
			}
	}

}
