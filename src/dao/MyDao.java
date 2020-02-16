package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.MyBean;
import connection1.MyConnection;

public class MyDao {

	public int insert(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();		
		PreparedStatement ps=con.prepareStatement("insert into PatientDetails (Honorific,"
				+ "FirstName,LastName,Gender,Age,Occupation,Religion,MaritalStatus,Address,"
				+ "Mobile,Email,RD,Path,FileName,Time) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, mb.getHonorific());
		ps.setString(2, mb.getFirstName());
		ps.setString(3, mb.getLastName());
		ps.setString(4, mb.getGender());
		ps.setString(5, mb.getAge());
		ps.setString(6, mb.getOccupation());
		ps.setString(7, mb.getReligion());
		ps.setString(8, mb.getMaritalStatus());
		ps.setString(9, mb.getAddress());
		ps.setString(10, mb.getMobile());
		ps.setString(11, mb.getEmail());
		ps.setString(12, mb.getRD());
		ps.setString(13, mb.getPath());
		ps.setString(14, mb.getFileName());
		ps.setString(15, mb.getTime());
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	public String[] ViewPatientDetailsForLabTestReport(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from PatientDetails where Id=?");
			ps.setString(1, mb.getId());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public String[] ViewDrProfileByDoctorForLabTestReport(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from DoctorDetails where RegId=?");
			ps.setString(1, mb.getRegId());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public int ReportInsert(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();		
		PreparedStatement ps=con.prepareStatement("insert into LabTestReport values(?,?,?,?,?,?)");
		ps.setString(1, mb.getId());
		ps.setString(2, mb.getRegId());
		ps.setString(3, mb.getPresNum());
		ps.setString(4, mb.getDate1());
		ps.setString(5, mb.getAdminPath());
		ps.setString(6, mb.getAdminFileName());
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	
	public int EPINSERT(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();		
		PreparedStatement ps=con.prepareStatement("insert into EP (EName,EAge,EAdd,EMobile1,EMobile2,Time,Status,RoomNum,DID) values(?,?,?,?,?,?,?,'PENDING',?)");
		
		ps.setString(1, mb.getName());
		ps.setString(2, mb.getAge());
		ps.setString(3, mb.getAddress());
		ps.setString(4, mb.getMobile());
		ps.setString(5, mb.getPhoNo());
		ps.setString(6, mb.getTime());
		ps.setString(7, mb.getRoomNum());
		ps.setString(8, mb.getRegId());
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	public int BookLabTest(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();		
		PreparedStatement ps=con.prepareStatement("insert into BookLabTest values(?,?,?,'PENDING')");
		ps.setString(1, mb.getId());
		ps.setString(2, mb.getRegId());
		ps.setString(3, mb.getPresNum());
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	public int LabTestReport(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();		
		PreparedStatement ps=con.prepareStatement("insert into LabTestReport values(?,?,?,?,?,?,?)");
		ps.setString(1, mb.getId());
		ps.setString(2, mb.getRegId());
		ps.setString(3, mb.getPresNum());
		ps.setString(4, mb.getDate1());
		ps.setString(5, mb.getL1());
		ps.setString(6, mb.getD1());
		ps.setString(7, mb.getR1());
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	
	public int RegistrationPayment(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();		
		PreparedStatement ps=con.prepareStatement("insert into RegistrationPayment (PatientName,Date1) values(?,?)");
		ps.setString(1, mb.getFirstName());
		ps.setString(2, mb.getDate1());
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	public int Discharge(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();		
		PreparedStatement ps=con.prepareStatement("insert into Discharge values(?,?)");
		ps.setString(1, mb.getId());
		ps.setString(2, mb.getDate1());
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	
	
	public int AdminReg(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();		
		PreparedStatement ps=con.prepareStatement("insert into Admin values(?,?,?,?,?,?,?,?)");
		ps.setString(1, mb.getAdminId());
		ps.setString(2, mb.getAdminPassword());
		ps.setString(3, mb.getAdminName());
		ps.setString(4, mb.getAdAddress());
		ps.setString(5, mb.getPhoNo());
		ps.setString(6, mb.getAEmailId());
		ps.setString(7, mb.getAdminPath());
		ps.setString(8, mb.getAdminFileName());
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	
	
	
	
	public int InsertMedicineByAdmin(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();		
		PreparedStatement ps=con.prepareStatement("insert into MedicineDetails values(?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, mb.getBrand());
		ps.setString(2, mb.getModelNo());
		ps.setString(3, mb.getMedName());
		ps.setString(4, mb.getType());
		ps.setString(5, mb.getQuantity());
		ps.setString(6, mb.getManufDate());
		ps.setString(7, mb.getExpDate());
		ps.setString(8, mb.getCOO());
		ps.setString(9, mb.getInStock());
		ps.setString(10, mb.getPrice());
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	
	
	public int InsertBiochemistryByAdmin(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();		
		PreparedStatement ps=con.prepareStatement("insert into Biochemistry values(?,?,?)");
		ps.setString(1, mb.getTestName());
		ps.setString(2, mb.getNormalRate());
		ps.setString(3, mb.getTPrice());
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	public int InsertColonscorpyByAdmin(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();		
		PreparedStatement ps=con.prepareStatement("insert into Colonscorpy values(?,?,?)");
		ps.setString(1, mb.getTestName());
		ps.setString(2, mb.getNormalRate());
		ps.setString(3, mb.getTPrice());
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	
	
	public int Attendence(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();		
		PreparedStatement ps=con.prepareStatement("insert into Attendence values(?,?,?)");
		ps.setString(1, mb.getAId());
		ps.setString(2, mb.getAttendence());
		ps.setString(3, mb.getADate());
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	
	
	public int InPatientDetails(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();		
		PreparedStatement ps=con.prepareStatement("insert into InPatientDetails values(?)");
		ps.setString(1, mb.getEPN());
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	
	
	
	
	public int PatientApp(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();		
		PreparedStatement ps=con.prepareStatement("insert into PatientAppDetails values(?,?,?,?,'PENDING')");
		ps.setString(1, mb.getId());
		ps.setString(2, mb.getBookingTime());
		ps.setString(3, mb.getDate1());
		ps.setString(4, mb.getRegId());
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	public int ChatInsert(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();		
		PreparedStatement ps=con.prepareStatement("insert into Chat values(?,?,?,?)");
		ps.setString(1, mb.getDate1());
		ps.setString(2, mb.getRegId());
		ps.setString(3, mb.getId());
		ps.setString(4, mb.getMsg());
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	public int ChatInsertByDoctor(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();		
		PreparedStatement ps=con.prepareStatement("insert into Chat values(?,?,?,?)");
		ps.setString(1, mb.getDate1());
		ps.setString(2, mb.getId());
		ps.setString(3, mb.getRegId());
		ps.setString(4, mb.getMsg());
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	
	public int doctorinsert(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps=con.prepareStatement("insert into DoctorDetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, mb.getRegId());
		ps.setString(2, mb.getName());
		ps.setString(3, mb.getDAge());
		ps.setString(4, mb.getQualification());
		ps.setString(5, mb.getSpecialization());
		ps.setString(6, mb.getExperience());
		ps.setString(7, mb.getArchievements());
		ps.setString(8, mb.getHouseNo());
		ps.setString(9, mb.getStreet());
		ps.setString(10, mb.getCity());
		ps.setString(11, mb.getState());
		ps.setString(12, mb.getCountry());
		ps.setString(13, mb.getZipCode());
		ps.setString(14, mb.getPhoneWorkPlace());
		ps.setString(15, mb.getPhoneResidence());
		ps.setString(16, mb.getDMobile());
		ps.setString(17, mb.getEmailId());
		ps.setString(18, mb.getAvaTime1());
		ps.setString(19, mb.getAvaTime2());
		ps.setString(20, mb.getAvaTime3());
		ps.setString(21, mb.getFees());
		result=ps.executeUpdate();
		//return result;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	
	
	
	public int Prescription(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps=con.prepareStatement("insert into Prescription(PresDate,PID,DrRegId,M1,M2,M3,M4,M5,D1,D2,D3,D4,D5,Q1,Q2,Q3,Q4,Q5,W1,W2,W3,W4,W5,L1,L2,L3,L4,L5,L6,L7,L8,L9,R1,R2,S1) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, mb.getPresDate());
		ps.setString(2, mb.getPID());
		ps.setString(3, mb.getDrRegId());
		ps.setString(4, mb.getM1());
		ps.setString(5, mb.getM2());
		ps.setString(6, mb.getM3());
		ps.setString(7, mb.getM4());
		ps.setString(8, mb.getM5());
		ps.setString(9, mb.getD1());
		ps.setString(10, mb.getD2());
		ps.setString(11, mb.getD3());
		ps.setString(12, mb.getD4());
		ps.setString(13, mb.getD5());
		ps.setString(14, mb.getQ1());
		ps.setString(15, mb.getQ2());
		ps.setString(16, mb.getQ3());
		ps.setString(17, mb.getQ4());
		ps.setString(18, mb.getQ5());
		ps.setString(19, mb.getW1());
		ps.setString(20, mb.getW2());
		ps.setString(21, mb.getW3());
		ps.setString(22, mb.getW4());
		ps.setString(23, mb.getW5());
		ps.setString(24, mb.getL1());
		ps.setString(25, mb.getL2());
		ps.setString(26, mb.getL3());
		ps.setString(27, mb.getL4());
		ps.setString(28, mb.getL5());
		ps.setString(29, mb.getL6());
		ps.setString(30, mb.getL7());
		ps.setString(31, mb.getL8());
		ps.setString(32, mb.getL9());
		ps.setString(33, mb.getR1());
		ps.setString(34, mb.getR2());
		ps.setString(35, mb.getS1());
		result=ps.executeUpdate();
		//return result;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	public int EPPrescription(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps=con.prepareStatement("insert into Treatment(DID,PID,M1,M2) values(?,?,?,?)");
		ps.setString(1, mb.getDrRegId());
		ps.setString(2, mb.getPID());
		ps.setString(3, mb.getM1());
		ps.setString(4, mb.getM2());
		result=ps.executeUpdate();
		//return result;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	
	public int Prescription1(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps=con.prepareStatement("insert into Prescription(PresDate) values(?)");
		ps.setString(1, mb.getPresDate());
		result=ps.executeUpdate();
		//return result;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	
	
	public String[] login(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from PatientDetails where Id=? AND Password=?");
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public String[] AdminLogin(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from Admin where AdminId=? AND AdminPasswod=?");
			//ps.setString(1, mb.getId());
			ps.setString(1, mb.getAdminId());
			ps.setString(2, mb.getAdminPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	
		
	public String[] DoctorLogin(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from DoctorDetails where RegId=?");
			ps.setString(1, mb.getRegId());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	
	
	public String id(MyBean mb)
	{
		String id = null;
		try {
			Connection con=MyConnection.dbConnection();	
			PreparedStatement ps=con.prepareStatement("select * from PatientDetails where Mobile=?");
			ps.setString(1, mb.getMobile());
			ResultSet rs=ps.executeQuery();
			//System.out.println(rs.getString(1));
			if(rs.next()) {
			id=rs.getString(1);
			return id;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	
	public ArrayList<String []> viewAll(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from PatientDetails");
			//ps.setI(1, mb.getEmpId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	
	public ArrayList<String []> ViewLabTestReportByPatient(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from LabTestReport where Id=?");
			ps.setString(1, mb.getId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	
	public ArrayList<String []> test(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from LabTestReport");
			//ps.setI(1, mb.getEmpId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	
	
	
	
	public ArrayList<String []> ViewAllLabTest(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from BookLabTest where Status='PENDING'");
			//ps.setI(1, mb.getEmpId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	public ArrayList<String []> FetchBioLabPrice(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from Biochemistry");
			//ps.setI(1, mb.getEmpId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	public ArrayList<String []> ViewPatientProblemByDoctor(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from Chat where From1=? Or To1=?");
			ps.setString(1, mb.getRegId());
			ps.setString(2, mb.getRegId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	public ArrayList<String []> viewAllChart(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from Chat where From1=? Or To1=?");
			//ps.setI(1, mb.getEmpId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	
	
	public ArrayList<String []> ViewAllPresByPatient(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from Prescription where PID=?");
			ps.setString(1, mb.getId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	public ArrayList<String []> ViewChat(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from Chat");
			//ps.setI(1, mb.getEmpId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	
	public ArrayList<String []> ViewAllAppByAdmin(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from PatientAppDetails");
			//ps.setI(1, mb.getEmpId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	public ArrayList<String []> ChkAllAppByPatient(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from PatientAppDetails where Id=?");
			ps.setString(1, mb.getId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	public ArrayList<String []> ViewAllTodayAppByAdmin(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from PatientAppDetails where Date1=?");
			ps.setString(1, mb.getDate1());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	public ArrayList<String []> ViewAllAppByAdminBetweenTwoDate(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from PatientAppDetails where Date1 Between ? AND ?");
			ps.setString(1, mb.getDate1());
			ps.setString(2, mb.getDate2());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	
	
	
	
	public ArrayList<String []> SearchDoctorName(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from DoctorDetails where Name=?");
			ps.setString(1, mb.getSearch());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	
	
	public ArrayList<String []> SearchDoctorSp(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from DoctorDetails where Specialization=?");
			ps.setString(1, mb.getSearch());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
		
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	
	
	public ArrayList<String []> viewAllDoctor(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from DoctorDetails");
			//ps.setI(1, mb.getEmpId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	
	public ArrayList<String []> Triage(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from Triage");
			//ps.setI(1, mb.getEmpId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	public ArrayList<String []> ViewAllTodayPatientByAdmin(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from PatientDetails where RD=?");
			ps.setString(1, mb.getDate1());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	public ArrayList<String []> ViewAllPatientByAdminBetweenTwoDate(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from PatientDetails where RD between ? AND ?");
			ps.setString(1, mb.getDate1());
			ps.setString(2, mb.getDate2());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	
	public ArrayList<String []> Biochemistry(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from Biochemistry");
			//ps.setI(1, mb.getEmpId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	public ArrayList<String []> Colonscorpy(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from Colonscorpy");
			//ps.setI(1, mb.getEmpId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	
	
	public ArrayList<String []> viewUROLOGIST(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from DoctorDetails where Specialization='UROLOGIST'");
			//ps.setI(1, mb.getEmpId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	
	
	
	public String[] doc(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from DoctorDetails where RegId=?");
			ps.setString(1, mb.getRegId());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	
	
	
	
	
	public ArrayList<String []> viewAllMedicine(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from MedicineDetails");
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	
	public ArrayList<String []> AppCheck(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from PatientAppDetails where RegId=? AND Status='PENDING'");
			ps.setString(1, mb.getRegId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}

	
	public ArrayList<String []> ViewEP(MyBean mb){
		ArrayList<String []> ar=new ArrayList<String []>();
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from EP where DID=?");
			ps.setString(1, mb.getRegId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			
			ar.add(data);
			
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			//ar.add(data);
			return ar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}

	

	public String[] ViewDoctorProfileByAdmin(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from DoctorDetails where RegId=?");
			//ps.setString(1, mb.getRegId());
			ps.setString(1, mb.getRegId());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public String[] viewProfile(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from PatientDetails where Id=? AND Password=?");
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	
	public String[] ViewRoom(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from Room where Num=?");
			ps.setString(1, mb.getRoomNum());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public String[] ViewIdPassword(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from PatientDetails where Time=?");
			ps.setString(1, mb.getTime());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public String[] ViewIdEP(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from EP where Time=?");
			ps.setString(1, mb.getTime());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	
	public String[] RegFee(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from RegFee");
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	
	
	public String[] ViewPatientProfileByDoctor(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from PatientDetails where Id=?");
			ps.setString(1, mb.getId());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	
	
	public String[] ViewDrProfileByDoctor(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from DoctorDetails where RegId=?");
			ps.setString(1, mb.getRegId());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public String[] ViewPresByPatient(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from Prescription where PresNum=?");
			ps.setString(1, mb.getPresNum());
			//ps.setString(2, mb.getRegId());
			//ps.setString(3, mb.getDate1());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public String[] PresDr(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from DoctorDetails where RegId=?");
			ps.setString(1, mb.getRegId());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	
	public String[] DrPatient(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from PatientDetails where Id=?");
			ps.setString(1, mb.getId());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public String[] ViewBiochemistryByAdmin(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from Biochemistry where TestName=?");
			ps.setString(1, mb.getTestName());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public String[] ViewColonscorpyByAdmin(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from Colonscorpy where TestName=?");
			ps.setString(1, mb.getTestName());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public String[] ViewMedicineByAdmin(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from MedicineDetails where ModelNo=?");
			ps.setString(1, mb.getModelNo());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public String[] FetchMedcine1Price(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from MedicineDetails where MedName=?");
			ps.setString(1, mb.getM1());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	
	public String[] FetchMedcine2Price(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from MedicineDetails where MedName=?");
			ps.setString(1, mb.getM2());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public String[] FetchMedcine3Price(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from MedicineDetails where MedName=?");
			ps.setString(1, mb.getM3());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public String[] FetchMedcine4Price(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from MedicineDetails where MedName=?");
			ps.setString(1, mb.getM4());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public String[] FetchMedcine5Price(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from MedicineDetails where MedName=?");
			ps.setString(1, mb.getM5());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	
	
	public String[] ViewProfileAdmin(MyBean mb) {
		String[] data=null;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from Admin where AdminId=?");
			ps.setString(1, mb.getAdminId());
			//ps.setString(2, mb.getPassword());
			ResultSet rs=ps.executeQuery();
			int count =rs.getMetaData().getColumnCount();
			while(rs.next()) {
			data=new String[count];
			for(int i=0;i<count;i++) {
				data[i]=rs.getString(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	
	public int update(MyBean mb) {
		int result=0;
		try {
			Connection con=MyConnection.dbConnection();	
			PreparedStatement ps=con.prepareStatement("update PatientDetails "
					+ "set Honorific=?, FirstName=?, LastName=?, Gender=?, Age=?,"
					+ " Occupation=?, Religion=?, MaritalStatus=?, Address=?, Mobile=?, "
					+ "Email=? where Id=? AND Password=?");
			ps.setString(1, mb.getHonorific());
			ps.setString(2, mb.getFirstName());
			ps.setString(3, mb.getLastName());
			ps.setString(4, mb.getGender());
			ps.setString(5, mb.getAge());
			ps.setString(6, mb.getOccupation());
			ps.setString(7, mb.getReligion());
			ps.setString(8, mb.getMaritalStatus());
			ps.setString(9, mb.getAddress());
			ps.setString(10, mb.getMobile());
			ps.setString(11, mb.getEmail());
			ps.setString(12, mb.getId());
			ps.setString(13, mb.getPassword());
			
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int UpdateAdminProfileByAdmin(MyBean mb) {
		int result=0;
		try {
			Connection con=MyConnection.dbConnection();	
			PreparedStatement ps=con.prepareStatement("update Admin set AdminName=?, AdAddress=?, PhoNo=?, AEmailId=? where AdminId=? AND AdminPasswod=?");
			ps.setString(1, mb.getAdminName());
			ps.setString(2, mb.getAdAddress());
			ps.setString(3, mb.getPhoNo());
			ps.setString(4, mb.getAEmailId());
			ps.setString(5, mb.getAdminId());
			ps.setString(6, mb.getAdminPassword());
			
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int UpdateReport(MyBean mb) {
		int result=0;
		try {
			Connection con=MyConnection.dbConnection();	
			PreparedStatement ps=con.prepareStatement("update BookLabTest set Status='DONE' where Id=? AND RegId=? AND PresNum=?");
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getRegId());
			ps.setString(3, mb.getPresNum());
			
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	public int UpdateMedicineStockByAdmin(MyBean mb) {
		int result=0;
		try {
			Connection con=MyConnection.dbConnection();	
			PreparedStatement ps=con.prepareStatement("update MedicineDetails set InSTock=? where ModelNo=?");
			//ps.setString(1, mb.getBrand());
			//ps.setString(2, mb.getMedName());
			//ps.setString(3, mb.getType());
			//ps.setString(4, mb.getQuantity());
			//ps.setString(5, mb.getManufDate());
			//ps.setString(6, mb.getExpDate());
			//ps.setString(7, mb.getCOO());
			ps.setString(1, mb.getInStock());
			//ps.setString(9, mb.getAddStock());
			//ps.setString(10, mb.getPrice());
			ps.setString(2, mb.getModelNo());
			
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int MedBuyUpdateMedStock(MyBean mb) {
		int result=0;
		try {
			Connection con=MyConnection.dbConnection();	
			PreparedStatement ps=con.prepareStatement("update MedicineDetails set InStock=? where MedName=?");
			ps.setString(1, mb.getInStock());
			ps.setString(2, mb.getM1());
			
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int UpdateMedicineByAdmin(MyBean mb) {
		int result=0;
		try {
			Connection con=MyConnection.dbConnection();	
			PreparedStatement ps=con.prepareStatement("update MedicineDetails set Brand=?,MedName=?,Type=?,Quantity=?,ManufDate=?,ExpDate=?,CountryOfOrigion=?,InStock=?,Price=? where ModelNo=?");
			ps.setString(1, mb.getBrand());
			ps.setString(2, mb.getMedName());
			ps.setString(3, mb.getType());
			ps.setString(4, mb.getQuantity());
			ps.setString(5, mb.getManufDate());
			ps.setString(6, mb.getExpDate());
			ps.setString(7, mb.getCOO());
			ps.setString(8, mb.getInStock());
			ps.setString(9, mb.getPrice());
			ps.setString(10, mb.getModelNo());
			
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	public int updatePatientDetailsByAdmin(MyBean mb) {
		int result=0;
		try {
			Connection con=MyConnection.dbConnection();	
			PreparedStatement ps=con.prepareStatement("update PatientDetails set Honorific=?,FirstName=?,LastName=?,Gender=?,Age=?,Occupation=?,Religion=?,MaritalStatus=?,Address=?,Mobile=?,Email=?,RD=? where Id=?  AND Password=?");
			//ps.setString(1, mb.getId());
			//ps.setString(2, mb.getPassword());
			ps.setString(1, mb.getHonorific());
			ps.setString(2, mb.getFirstName());
			ps.setString(3, mb.getLastName());
			ps.setString(4, mb.getGender());
			ps.setString(5, mb.getAge());
			ps.setString(6, mb.getOccupation());
			ps.setString(7, mb.getReligion());
			ps.setString(8, mb.getMaritalStatus());
			ps.setString(9, mb.getAddress());
			ps.setString(10, mb.getMobile());
			ps.setString(11, mb.getEmail());
			ps.setString(12, mb.getRD());
			ps.setString(13, mb.getId());
			ps.setString(14, mb.getPassword());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int UpdateBiochemistryByAdmin(MyBean mb) {
		int result=0;
		try {
			Connection con=MyConnection.dbConnection();	
			PreparedStatement ps=con.prepareStatement("update Biochemistry set NormalRate=?, Price=? where TestName=?");
			ps.setString(1, mb.getNormalRate());
			ps.setString(2, mb.getTPrice());
			ps.setString(3, mb.getTestName());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int UpdateColonscorpyByAdmin(MyBean mb) {
		int result=0;
		try {
			Connection con=MyConnection.dbConnection();	
			PreparedStatement ps=con.prepareStatement("update Colonscorpy set NormalRate=?, Price=? where TestName=?");
			ps.setString(1, mb.getNormalRate());
			ps.setString(2, mb.getTPrice());
			ps.setString(3, mb.getTestName());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int PatientAppUpdateByDoctor(MyBean mb) {
		int result=0;
		try {
			Connection con=MyConnection.dbConnection();	
			PreparedStatement ps=con.prepareStatement("update PatientAppDetails set Status=? where Id=? AND RegId=?");
			ps.setString(1, mb.getStatus());
			ps.setString(2, mb.getPID());
			ps.setString(3, mb.getDrRegId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int RoomAllo(MyBean mb) {
		int result=0;
		try {
			Connection con=MyConnection.dbConnection();	
			PreparedStatement ps=con.prepareStatement("update Room set Ava=? where Num=?");
			ps.setString(1, mb.getAVA());
			ps.setString(2, mb.getRoomNum());
			//
			//ps.setString(3, mb.getDrRegId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int RoomUpdate(MyBean mb) {
		int result=0;
		try {
			Connection con=MyConnection.dbConnection();	
			PreparedStatement ps=con.prepareStatement("update Room set Ava=? where Num=?");
			ps.setString(1, mb.getAVA());
			ps.setString(2, mb.getRoomNum());
			//
			//ps.setString(3, mb.getDrRegId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int EPUPDATE(MyBean mb) {
		int result=0;
		try {
			Connection con=MyConnection.dbConnection();	
			PreparedStatement ps=con.prepareStatement("update EP set Status='DEPEND' where EID=?");
			//ps.setString(1, mb.getStatus());
			ps.setString(1, mb.getId());
			//
			//ps.setString(3, mb.getDrRegId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	public int AppUpdate(MyBean mb) {
		int result=0;
		try {
			Connection con=MyConnection.dbConnection();	
			PreparedStatement ps=con.prepareStatement("update PatientAppDetails set Status=?, where Id=?");
			ps.setString(1, mb.getStatus());
			ps.setString(2, mb.getPID());
			//ps.setString(3, mb.getTestName());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	public int UpdateDoctorDetailsByAdmin(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps=con.prepareStatement("update DoctorDetails set Name=?, DAge=?, Qualification=?, Specialization=?, Experience=?, Archievements=?, HouseNo=?, Street=?, City=?, State=?, Country=?, ZipCode=?, PhoneWorkPlace=?, PhoneResidence=?, DMobile=?, EmailId=?, AvaTime1=?, AvaTime2=?, AvaTime3=?, Fees=? where RegId=?");
		
		ps.setString(1, mb.getName());
		ps.setString(2, mb.getDAge());
		ps.setString(3, mb.getQualification());
		ps.setString(4, mb.getSpecialization());
		ps.setString(5, mb.getExperience());
		ps.setString(6, mb.getArchievements());
		ps.setString(7, mb.getHouseNo());
		ps.setString(8, mb.getStreet());
		ps.setString(9, mb.getCity());
		ps.setString(10, mb.getState());
		ps.setString(11, mb.getCountry());
		ps.setString(12, mb.getZipCode());
		ps.setString(13, mb.getPhoneWorkPlace());
		ps.setString(14, mb.getPhoneResidence());
		ps.setString(15, mb.getDMobile());
		ps.setString(16, mb.getEmailId());
		ps.setString(17, mb.getAvaTime1());
		ps.setString(18, mb.getAvaTime2());
		ps.setString(19, mb.getAvaTime3());
		ps.setString(20, mb.getFees());
		ps.setString(21, mb.getRegId());
		
		result=ps.executeUpdate();
		//return result;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	public int UpdateDrProfileByDoctor(MyBean mb) {
		int result=0;
	try {
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps=con.prepareStatement("update DoctorDetails set Name=?, DAge=?, Qualification=?, Specialization=?, Experience=?, Archievements=?, HouseNo=?, Street=?, City=?, State=?, Country=?, ZipCode=?, PhoneWorkPlace=?, PhoneResidence=?, DMobile=?, EmailId=?, AvaTime1=?, AvaTime2=?, AvaTime3=?, Fees=? where RegId=?");
		ps.setString(1, mb.getName());
		ps.setString(2, mb.getDAge());
		ps.setString(3, mb.getQualification());
		ps.setString(4, mb.getSpecialization());
		ps.setString(5, mb.getExperience());
		ps.setString(6, mb.getArchievements());
		ps.setString(7, mb.getHouseNo());
		ps.setString(8, mb.getStreet());
		ps.setString(9, mb.getCity());
		ps.setString(10, mb.getState());
		ps.setString(11, mb.getCountry());
		ps.setString(12, mb.getZipCode());
		ps.setString(13, mb.getPhoneWorkPlace());
		ps.setString(14, mb.getPhoneResidence());
		ps.setString(15, mb.getDMobile());
		ps.setString(16, mb.getEmailId());
		ps.setString(17, mb.getAvaTime1());
		ps.setString(18, mb.getAvaTime2());
		ps.setString(19, mb.getAvaTime3());
		ps.setString(20, mb.getFees());
		ps.setString(21, mb.getRegId());
		
		
		result=ps.executeUpdate();
		//return result;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	
	public int deletePatientDetailsByAdmin(MyBean mb) {
		int i=0;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("delete from PatientDetails where Id=? AND Password=?");
			ps.setString(1, mb.getId());
			ps.setString(1, mb.getPassword());
			i=ps.executeUpdate();
			return i;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
	public int DeleteDoctorDetailsByAdmin(MyBean mb) {
		int i=0;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("delete from DoctorDetails where RegId=?");
			ps.setString(1, mb.getRegId());
			//ps.setString(1, mb.getPassword());
			i=ps.executeUpdate();
			return i;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int DeleteMedicineDetailsByAdmin(MyBean mb) {
		int i=0;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("delete from MedicineDetails where ModelNo=?");
			ps.setString(1, mb.getModelNo());
			i=ps.executeUpdate();
			return i;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int DeleteBiochemistryByAdmin(MyBean mb) {
		int i=0;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("delete from Biochemistry where TestName=?");
			ps.setString(1, mb.getTestName());
			//ps.setString(1, mb.getPassword());
			i=ps.executeUpdate();
			return i;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
	public int DeleteColonscorpyByAdmin(MyBean mb) {
		int i=0;
		Connection con=MyConnection.dbConnection();	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("delete from Colonscorpy where TestName=?");
			ps.setString(1, mb.getTestName());
			//ps.setString(1, mb.getPassword());
			i=ps.executeUpdate();
			return i;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}
