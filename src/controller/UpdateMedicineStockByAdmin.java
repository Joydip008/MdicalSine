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
 * Servlet implementation class UpdateMedicineStockByAdmin
 */
@WebServlet("/UpdateMedicineStockByAdmin")
public class UpdateMedicineStockByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMedicineStockByAdmin() {
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
//		mb.setBrand(request.getParameter("Brand"));
//		mb.setModelNo(request.getParameter("ModelNo"));
//		mb.setMedName(request.getParameter("MedName"));
		HttpSession session=request.getSession();
		mb.setBrand((String)session.getAttribute("Brand"));
		mb.setModelNo((String)session.getAttribute("ModelNo"));
		mb.setMedName((String)session.getAttribute("MedName"));
		String InStock=(String)session.getAttribute("InStock");
		String AddStock=(request.getParameter("AddStock"));
		
		int sum1=0,sum2=0;
		sum1=Integer.parseInt(InStock);
		sum2=Integer.parseInt(AddStock);
		
		sum1=sum1+sum2;
		mb.setInStock(Integer.toString(sum1));
		
		//out.print((String)session.getAttribute("Brand"));
		i=dao.UpdateMedicineStockByAdmin(mb);
		if(i>0) {
		//out.print("Updated");	
		RequestDispatcher rd=request.getRequestDispatcher("ViewAllMedicineByAdmin.jsp");
		rd.forward(request, response);
		}
		else {
			out.print("not updated");
		}
	}

}
