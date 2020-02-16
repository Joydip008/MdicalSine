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
 * Servlet implementation class UpdateDrProfileByDoctor
 */
@WebServlet("/UpdateDrProfileByDoctor")
public class UpdateDrProfileByDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MyBean mb=new MyBean();
    MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDrProfileByDoctor() {
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
		i=dao.UpdateDrProfileByDoctor(mb);
		if(i>0) {
		//out.print("Updated");	
			HttpSession session=request.getSession();
			session.setAttribute("RegId", request.getParameter("RegId"));
		RequestDispatcher rd=request.getRequestDispatcher("ViewDrProfileByDoctor.jsp");
		rd.forward(request, response);
		}
		else {
			out.print("not updated");
		}
	}

}
