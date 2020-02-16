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
 * Servlet implementation class MedBuyUpdateMedStock
 */
@WebServlet("/MedBuyUpdateMedStock")
public class MedBuyUpdateMedStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedBuyUpdateMedStock() {
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
		int sum1=0,sum2=0;
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		mb.setM1((String)session.getAttribute("M1"));
		String InStock1=(String)session.getAttribute("S1");
		String AddStock1=((String)session.getAttribute("Q1"));
		sum1=Integer.parseInt(InStock1);
		sum2=Integer.parseInt(AddStock1);
		sum1=sum1-sum2;
		mb.setInStock(Integer.toString(sum1));
		i=dao.MedBuyUpdateMedStock(mb);
		
			mb.setM1((String)session.getAttribute("M2"));
			String InStock2=(String)session.getAttribute("S2");
			String AddStock2=((String)session.getAttribute("Q2"));
			sum1=Integer.parseInt(InStock2);
			sum2=Integer.parseInt(AddStock2);
			sum1=sum1-sum2;
			mb.setInStock(Integer.toString(sum1));
			i=dao.MedBuyUpdateMedStock(mb);
			
			mb.setM1((String)session.getAttribute("M3"));
			String InStock3=(String)session.getAttribute("S3");
			String AddStock3=((String)session.getAttribute("Q3"));
			sum1=Integer.parseInt(InStock3);
			sum2=Integer.parseInt(AddStock3);
			sum1=sum1-sum2;
			mb.setInStock(Integer.toString(sum1));
			i=dao.MedBuyUpdateMedStock(mb);
			
			
			mb.setM1((String)session.getAttribute("M4"));
			String InStock4=(String)session.getAttribute("S4");
			String AddStock4=((String)session.getAttribute("Q4"));
			sum1=Integer.parseInt(InStock4);
			sum2=Integer.parseInt(AddStock4);
			sum1=sum1-sum2;
			mb.setInStock(Integer.toString(sum1));
			i=dao.MedBuyUpdateMedStock(mb);

			mb.setM1((String)session.getAttribute("M5"));
			String InStock5=(String)session.getAttribute("S5");
			String AddStock5=((String)session.getAttribute("Q5"));
			sum1=Integer.parseInt(InStock5);
			sum2=Integer.parseInt(AddStock5);
			sum1=sum1-sum2;
			mb.setInStock(Integer.toString(sum1));
			i=dao.MedBuyUpdateMedStock(mb);
		if(i>0) {
		//out.print("Updated");	
		RequestDispatcher rd=request.getRequestDispatcher("SuccessfulMedicineBuy.jsp");
		rd.forward(request, response);
		}
		else {
			out.print("not updated");
		}
	}

}
