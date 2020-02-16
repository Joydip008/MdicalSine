package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MyBean;
import dao.MyDao;

/**
 * Servlet implementation class UpdateAdminProfileByAdmin
 */
@WebServlet("/UpdateAdminProfileByAdmin")
public class UpdateAdminProfileByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminProfileByAdmin() {
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
		mb.setAdminId(request.getParameter("AdminId"));
		mb.setAdminPassword(request.getParameter("AdminPassword"));
		mb.setAdminName(request.getParameter("AdminName"));
		mb.setAdAddress(request.getParameter("AdAddress"));
		mb.setPhoNo(request.getParameter("PhoNo"));
		mb.setAEmailId(request.getParameter("AEmailId"));
		out.print(request.getParameter("AdminId"));
		out.print(request.getParameter("AdminPassword"));
		i=dao.UpdateAdminProfileByAdmin(mb);
		if(i>0) {
		//out.print("Updated");	
//		RequestDispatcher rd=request.getRequestDispatcher("viewProfile.jsp");
//		rd.forward(request, response);
			HttpSession session=request.getSession();
			session.setAttribute("AdminId",request.getParameter("AdminId"));
			response.sendRedirect("ViewAdminProfile.jsp");
		}
		else {
			out.print("not updated");
		}
	}

}
