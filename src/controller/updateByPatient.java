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
 * Servlet implementation class updateByPatient
 */
@WebServlet("/updateByPatient")
public class updateByPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateByPatient() {
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
		mb.setId(request.getParameter("Id"));
		mb.setPassword(request.getParameter("Password"));
		
//		out.println(request.getParameter("Honorific"));
//		out.println(request.getParameter("FirstName"));
//		out.println(request.getParameter("LastName"));
//		out.println(request.getParameter("Gender"));
//		out.println(request.getParameter("Age"));
//		out.println(request.getParameter("Occupation"));
//		out.println(request.getParameter("Religion"));
//		out.println(request.getParameter("MaritalStatus"));
//		out.println(request.getParameter("Address"));
//		out.println(request.getParameter("Mobile"));
//		out.println(request.getParameter("Email"));
//		out.println(request.getParameter("Id"));
//		//out.println(request.getParameter("Password"));
		
		
		i=dao.update(mb);
		if(i>0) {
		//out.print("Updated");	
//		RequestDispatcher rd=request.getRequestDispatcher("viewProfile.jsp");
//		rd.forward(request, response);
			response.sendRedirect("viewProfile.jsp");
		}
		else {
			out.print("not updated");
		}
	}
}
