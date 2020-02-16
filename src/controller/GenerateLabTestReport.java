package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MyBean;
import dao.MyDao;

/**
 * Servlet implementation class GenerateLabTestReport
 */
@WebServlet("/GenerateLabTestReport")
public class GenerateLabTestReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateLabTestReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int i=0,j=0;
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		mb.setId((String)session.getAttribute("Id"));
		mb.setRegId((String)session.getAttribute("RegId"));
		mb.setPresNum((String)session.getAttribute("PresNum"));
		mb.setL1((String)session.getAttribute("Biochemistry"));
		mb.setR1(request.getParameter("R1"));
		mb.setD1(request.getParameter("N1"));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		mb.setDate1(dtf.format(localDate));
		i=dao.LabTestReport(mb);
		if(i>0) {
			//System.out.println("Data Insert Succesful:");
			out.print("Success");
			//response.sendRedirect("ViewAllDoctorByAdmin");
			//mb.setStatus(request.getParameter("Status"));
			//i=dao.AppUpdate(mb);
			//RequestDispatcher rd=request.getRequestDispatcher("ViewAllMedicineByAdmin.jsp");
			//rd.forward(request, response);
			//RequestDispatcher rd=request.getRequestDispatcher("clickHere.html");
			//rd.forward(request, response);
		}
		else {
			out.print(" Not................Success");
		}
	}

}
