package controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import bean.MyBean;
import dao.MyDao;
import jdk.jfr.events.FileWriteEvent;

/**
 * Servlet implementation class PatientRegistration
 */
@WebServlet("/PatientRegistration")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 *2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class PatientRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
       FileItem flItem = null;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientRegistration() {
        super();
        
        // TODO Auto-generated constructor stub
    }
   /* private String extractFileName(Part part)
    {
    	String contentDisp = part.getHeader("content-disposition");
    	String[] items = contentDisp.split(";");
    	for (String s : items)
    	{
    		if (s.trim().startsWith("filename"))
    			return s.substring(s.indexOf("=") + 2, s.length() - 1);
    	}
    	return "";
    }*/
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
   
    
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i=0,j=0;
		//request.getParameter("Mobile")String m1=;
		//System.out.println("Mobile no is"+Integer.parseInt(request.getParameter("Mobile")));
				//mb.setMobile(Integer.parseInt(request.getParameter("Mobile")));
				//long mobile=Long.parseLong(request.getParameter("Mobile"));
				//System.out.println(mobile);
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		mb.setHonorific((String)session.getAttribute("Honorific"));
		mb.setFirstName((String)session.getAttribute("FirstName"));
		//session.setAttribute("FirstName", (String)session.getAttribute("FirstName"));
		mb.setLastName((String)session.getAttribute("LastName"));
		mb.setGender((String)session.getAttribute("Gender"));
		mb.setAge((String)session.getAttribute("Age"));
		mb.setOccupation((String)session.getAttribute("Occupation"));
		mb.setReligion((String)session.getAttribute("Religion"));
		mb.setMaritalStatus((String)session.getAttribute("MaritalStatus"));
		mb.setAddress((String)session.getAttribute("Address"));
		mb.setMobile((String)session.getAttribute("Mobile"));
		mb.setEmail((String)session.getAttribute("Email"));	
		
	   //out.print((String)session.getAttribute("Honorific"));
	   
		response.setContentType("text/html;charset=UTF-8");
		//Part part = request.getPart("Photo");
		//String filename = extractFileName(part);
		
		String filename=(String)session.getAttribute("Photo");
		String savePath = "C:\\Users\\JOYDIP\\eclipse-workspace\\MedicalSine\\WebContent\\PatientImg\\" + File.separator + filename;
		File fileSaveDir = new File(savePath);
		//part.write(savePath + File.separator);
		
		
		mb.setPath(savePath);
		mb.setFileName(filename);
		
		//out.print(savePath);
		//out.print(filename);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		mb.setRD(dtf.format(localDate));
		mb.setDate1(dtf.format(localDate));
		
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		//System.out.println(sdf.format(date));
		mb.setTime(sdf.format(date));
		     
		
		i=dao.insert(mb);
		j=dao.RegistrationPayment(mb);
		if(i>0 && j>0) {
			
			
			//System.out.println("Data Insert Succesful:");
			//out.print("Success");
			////////response.sendRedirect("PAGENAME.html");
			session.setAttribute("Time",sdf.format(date));
			RequestDispatcher rd=request.getRequestDispatcher("SuccessfulRegistration.jsp");
			rd.forward(request, response);
			//RequestDispatcher rd=request.getRequestDispatcher("clickHere.html");
			//rd.forward(request, response);
		}
		else {
			out.print(" NotSuccess");
		}
        }
}
