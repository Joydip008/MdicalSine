package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;

import bean.MyBean;
import dao.MyDao;

/**
 * Servlet implementation class UploadLabTestReport
 */
@WebServlet("/UploadLabTestReport")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 *2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class UploadLabTestReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyBean mb= new MyBean();
       MyDao dao=new MyDao();
       FileItem flItem = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadLabTestReport() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int i=0,j=0;
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		mb.setId((String)session.getAttribute("Id"));
		mb.setRegId((String)session.getAttribute("RegId"));
		mb.setPresNum((String)session.getAttribute("PresNum"));
		
		out.println((String)session.getAttribute("PresNum"));
		out.println((String)session.getAttribute("Id"));
		out.println((String)session.getAttribute("PresNum"));
		

		//response.setContentType("text/file;charset=UTF-8");
		Part part = request.getPart("UploadReport");
		String filename = extractFileName(part);
		String savePath = "C:\\Users\\JOYDIP\\eclipse-workspace\\MedicalSine\\WebContent\\LabReport\\" + File.separator + filename;
		File fileSaveDir = new File(savePath);
		part.write(savePath + File.separator);
		
		
		mb.setAdminPath(savePath);
		mb.setAdminFileName(filename);
		
		//out.println(savePath);
		//out.print(filename);
		
		
		
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		mb.setRD(dtf.format(localDate));
		mb.setDate1(dtf.format(localDate));
		
		i=dao.ReportInsert(mb);
		j=dao.UpdateReport(mb);
		if(i>0 && j>0) {
			
			
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
