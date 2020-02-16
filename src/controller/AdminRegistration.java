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
import java.time.LocalDateTime;
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
@WebServlet("/AdminRegistration")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 *2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class AdminRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb=new MyBean();
       MyDao dao=new MyDao();
       FileItem flItem = null;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegistration() {
        super();
        
        // TODO Auto-generated constructor stub
    }
    private String extractFileName(Part part)
    {
    	String contentDisp = part.getHeader("content-disposition");
    	String[] items = contentDisp.split(";");
    	for (String s : items)
    	{
    		if (s.trim().startsWith("filename"))
    			return s.substring(s.indexOf("=") + 2, s.length() - 1);
    	}
    	return "";
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
		
		out.println(request.getParameter("AdminId"));
		out.println(request.getParameter("AdminPassword"));
		out.println(request.getParameter("AdminName"));
		out.println(request.getParameter("AdAddress"));
		out.println(request.getParameter("PhoNo"));
		out.println(request.getParameter("AEmailId"));
		
	   
		response.setContentType("text/html;charset=UTF-8");
		Part part = request.getPart("AdminPhoto");
		String filename = extractFileName(part);
		String savePath = "C:\\Users\\JOYDIP\\eclipse-workspace\\MedicalSine\\WebContent\\ADMIN\\" + File.separator + filename;
		File fileSaveDir = new File(savePath);
		part.write(savePath + File.separator);
		
		
		mb.setAdminPath(savePath);
		mb.setAdminFileName(filename);
		
		out.println(request.getParameter("savePath"));
		out.print(request.getParameter("filename"));
		
		
		
		/*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now(); 
		   String var=dtf.format(now);
		mb.setRD(var);
		   //System.out.println(dtf.format(now));  */
		i=dao.AdminReg(mb);
		if(i>0) {
			
			
			//System.out.println("Data Insert Succesful:");
			out.print("Success");
			////////response.sendRedirect("PAGENAME.html");
			//RequestDispatcher rd=request.getRequestDispatcher("login.html");
			//rd.forward(request, response);
			//RequestDispatcher rd=request.getRequestDispatcher("clickHere.html");
			//rd.forward(request, response);
		}
		else {
			out.print(" NotSuccess");
		}
        }
}
