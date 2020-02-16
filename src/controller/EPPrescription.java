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
 * Servlet implementation class EPPrescription
 */
@WebServlet("/EPPrescription")
public class EPPrescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EPPrescription() {
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
		mb.setPID(request.getParameter("PID"));
		//out.print(request.getParameter("PID"));
		mb.setDrRegId(request.getParameter("DrRegId"));
		mb.setM1(request.getParameter("M1"));
		mb.setM2(request.getParameter("M2"));
		out.print(request.getParameter("M1"));
		out.print(request.getParameter("M2"));
		i=dao.EPPrescription(mb);
		//j=dao.PatientAppUpdateByDoctor(mb);
		
		if(i>0) {
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
