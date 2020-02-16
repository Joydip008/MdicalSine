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
 * Servlet implementation class UpdateColonscorpyByAdmin
 */
@WebServlet("/UpdateColonscorpyByAdmin")
public class UpdateColonscorpyByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MyBean mb=new MyBean();
    MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateColonscorpyByAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		int i=0;
		mb.setTestName(request.getParameter("TestName"));
		mb.setNormalRate(request.getParameter("NormalRate"));
		mb.setTPrice(request.getParameter("TPrice"));
		i=dao.UpdateColonscorpyByAdmin(mb);
		if(i>0) {
		//out.print("Updated");	
		RequestDispatcher rd=request.getRequestDispatcher("Biochemistry.jsp");
		rd.forward(request, response);
		}
		else {
			out.print("not updated");
		}
	}

}
