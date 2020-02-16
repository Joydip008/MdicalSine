package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MyBean;
import connection1.MyConnection;
import dao.MyDao;

/**
 * Servlet implementation class generateId
 */
@WebServlet("/generateId")
public class generateId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public generateId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		mb.setMobile(request.getParameter("Mobile"));
		String mobile=request.getParameter("Mobile");
		String pass=dao.id(mb);
		//out.println(pass);
		//out.println(mobile);
		response.setContentType("text/html");  
		//PrintWriter out = response.getWriter();
		//out.println("<html><body><center><h1>This Is Your </body></html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>");
		out.println("Hello " + "  " + mobile + "WELCOME TO MY COMPANY ");
		out.println("Your password is : " + "  " + pass + "<br>");
		out.println("<a href= 'index.html'>CLICK</a>");
		out.println("</h1>");
		out.println("</center>");
		out.println("</body></html>");
	}
	
}
