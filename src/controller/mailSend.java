package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mailSend
 */
@WebServlet("/mailSend")
public class mailSend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host;
    private String port;
    private String user;
    private String pass;
 
//    public void init() {
//        // reads SMTP server setting from web.xml file
//        ServletContext context = getServletContext();
//        host = "smtp.gmail.com";
//        port = "465";
//        user = "saniasatra@gmail.com";
//        pass = "27041995";
//    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mailSend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String Id = request.getParameter("Id");
//      String Password = request.getParameter("Password");
//      String FirstName = request.getParameter("FirstName");

      String resultMessage = "";
      PrintWriter out=response.getWriter();
     
      	EmailUtility.sendEmail("saniasatra@gmail.com", "hello", "hi"); 
          resultMessage = "The e-mail was sent successfully";
    
     out.print("Success");
  }
}