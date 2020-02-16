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
 * Servlet implementation class updatePatientDetailsByAdmin
 */
@WebServlet("/updatePatientDetailsByAdmin")
public class updatePatientDetailsByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MyBean mb=new MyBean();
    MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatePatientDetailsByAdmin() {
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
		mb.setId(request.getParameter("Id"));
		mb.setPassword(request.getParameter("Password"));
		mb.setHonorific(request.getParameter("Honorific"));
		mb.setFirstName(request.getParameter("FirstName"));
		mb.setLastName(request.getParameter("LastName"));
		mb.setGender(request.getParameter("Gender"));
		mb.setAge(request.getParameter("Age"));
		mb.setOccupation(request.getParameter("Occupation"));
		mb.setReligion(request.getParameter("Religion"));
		mb.setMaritalStatus(request.getParameter("MaritalStatus"));
		mb.setAddress(request.getParameter("Address"));
		mb.setMobile(request.getParameter("Mobile"));
		mb.setEmail(request.getParameter("Email"));
		mb.setRD(request.getParameter("RD"));
		i=dao.updatePatientDetailsByAdmin(mb);
		if(i>0) {
		//out.print("Updated");	
		RequestDispatcher rd=request.getRequestDispatcher("viewAll.jsp");
		rd.forward(request, response);
		}
		else {
			out.print("not updated");
		}
	}

}
