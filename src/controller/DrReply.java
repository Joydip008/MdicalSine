package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
 * Servlet implementation class DrReply
 */
@WebServlet("/DrReply")
public class DrReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrReply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i=0;
		PrintWriter out=response.getWriter();
		mb.setId(request.getParameter("Pid"));
		mb.setRegId(request.getParameter("RegId"));
		mb.setMsg(request.getParameter("Msg"));
		out.print(request.getParameter("Pid"));
		out.print(request.getParameter("RegId"));
		out.print(request.getParameter("Msg"));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		//System.out.println(dtf.format(localDate));
		
		mb.setDate1(dtf.format(localDate));
		i=dao.ChatInsertByDoctor(mb);
		if(i>0) {
		//out.print("Updated");	
			HttpSession session=request.getSession();
			session.setAttribute("RegId", request.getParameter("RegId"));
		RequestDispatcher rd=request.getRequestDispatcher("Chat.jsp");
		rd.forward(request, response);
		}
		else {
			out.print("not updated");
		}
	}

}
