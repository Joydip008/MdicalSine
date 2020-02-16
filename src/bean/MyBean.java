package bean;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.time.LocalDate;

import com.oreilly.servlet.MultipartRequest;

import oracle.sql.BLOB;

public class MyBean {
	//Patient
	private String Id,Password,Honorific,FirstName,LastName,gender,Occupation,Religion,MaritalStatus,Address,Email,RD,LLD;
	//private int Age;
	private String Mobile,Age,Time;
	
	private String RoomNum,AVA;
	
	//Doctor
	private String RegId ,Name,DAge,Qualification,Specialization,Experience,Archievements,HouseNo,Street,City,State,Country,ZipCode,Fax,EmailId,AvaTime1,AvaTime2,AvaTime3,Fees,DMobile;
	private String PhoneWorkPlace,PhoneResidence;
	
	//Mediine
	private String Brand,ModelNo,MedName,Type,Quantity,ManufDate,ExpDate,COO,InStock,Price;
	// LABSSSSSS
	private String TestName,NormalRate,TPrice;
	//
	private String AddStock;
	//PatientImage
	private String Path,FileName;
	//PatientAppBook
	private String BookingTime,Status,Date1,PayStatus;
	//Emergency 
	private String EPN;
	//Attendence
	private String AId,Attendence,ADate;
	//private LocalDate ADate;
	//
	private String Search;
	//private Blob Photo;
	//ADMIN
	private String AdminId,AdminPassword,AdAddress,PhoNo,AEmailId,AdminName,AdminFileName,AdminPath;
	//Triage
	private int SeNum;
	
	//Prescription
	private String PID,DrRegId,M1,M2,M3,M4,M5,D1,D2,D3,D4,D5,Q1,Q2,Q3,Q4,Q5,W1,W2,W3,W4,W5,L1,L2,L3,L4,L5,L6,L7,L8,L9,R1,R2,S1,PresDate;
	private String PresNum;
	//Chat
	private String To1,From1,Msg;
	
	private String Date2;
	
	public String getAVA() {
		return AVA;
	}

	public void setAVA(String aVA) {
		AVA = aVA;
	}

	public String getRoomNum() {
		return RoomNum;
	}

	public void setRoomNum(String roomNum) {
		RoomNum = roomNum;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getDate2() {
		return Date2;
	}

	public void setDate2(String date2) {
		Date2 = date2;
	}

	public String getPresNum() {
		return PresNum;
	}

	public void setPresNum(String presNum) {
		PresNum = presNum;
	}

	public String getPayStatus() {
		return PayStatus;
	}

	public void setPayStatus(String payStatus) {
		PayStatus = payStatus;
	}

	public String getTo1() {
		return To1;
	}

	public void setTo1(String to1) {
		To1 = to1;
	}

	public String getFrom1() {
		return From1;
	}

	public void setFrom1(String from1) {
		From1 = from1;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

	public String getPresDate() {
		return PresDate;
	}

	public void setPresDate(String presDate) {
		PresDate = presDate;
	}

	public String getTestName() {
		return TestName;
	}

	public void setTestName(String testName) {
		TestName = testName;
	}

	public String getNormalRate() {
		return NormalRate;
	}

	public void setNormalRate(String normalRate) {
		NormalRate = normalRate;
	}

	public String getTPrice() {
		return TPrice;
	}

	public void setTPrice(String tPrice) {
		TPrice = tPrice;
	}

	public String getAddStock() {
		return AddStock;
	}

	public void setAddStock(String addStock) {
		AddStock = addStock;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getDate1() {
		return Date1;
	}

	public void setDate1(String date1) {
		Date1 = date1;
	}
	
	public String getAdminId() {
		return AdminId;
	}

	public String getAdAddress() {
		return AdAddress;
	}

	public void setAdAddress(String adAddress) {
		AdAddress = adAddress;
	}

	public String getPhoNo() {
		return PhoNo;
	}

	public void setPhoNo(String phoNo) {
		PhoNo = phoNo;
	}

	public String getAEmailId() {
		return AEmailId;
	}

	public void setAEmailId(String aEmailId) {
		AEmailId = aEmailId;
	}

	public void setAdminId(String adminId) {
		AdminId = adminId;
	}

	public String getAdminPassword() {
		return AdminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}

	public String getAdminName() {
		return AdminName;
	}

	public void setAdminName(String adminName) {
		AdminName = adminName;
	}

	public String getAdminFileName() {
		return AdminFileName;
	}

	public void setAdminFileName(String adminFileName) {
		AdminFileName = adminFileName;
	}

	public String getAdminPath() {
		return AdminPath;
	}

	public void setAdminPath(String adminPath) {
		AdminPath = adminPath;
	}	
	
	public int getSeNum() {
		return SeNum;
	}

	public void setSeNum(int seNum) {
		SeNum = seNum;
	}

	public String getSearch() {
		return Search;
	}

	public void setSearch(String search) {
		Search = search;
	}


	public String getAId() {
		return AId;
	}

	public void setAId(String aId) {
		AId = aId;
	}

	public String getAttendence() {
		return Attendence;
	}

	public void setAttendence(String attendence) {
		Attendence = attendence;
	}

	public String getADate() {
		return ADate;
	}

	public void setADate(String aDate) {
		ADate = aDate;
	}

	public String getEPN() {
		return EPN;
	}

	public void setEPN(String ePN) {
		EPN = ePN;
	}

	public String getBookingTime() {
		return BookingTime;
	}

	public void setBookingTime(String bookingTime) {
		BookingTime = bookingTime;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}


	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public String getAvaTime1() {
		return AvaTime1;
	}
	
	public void setAvaTime1(String avaTime1) {
		AvaTime1 = avaTime1;
	}

	public String getAvaTime2() {
		return AvaTime2;
	}

	public void setAvaTime2(String avaTime2) {
		AvaTime2 = avaTime2;
	}

	public String getAvaTime3() {
		return AvaTime3;
	}

	public void setAvaTime3(String avaTime3) {
		AvaTime3 = avaTime3;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getModelNo() {
		return ModelNo;
	}

	public void setModelNo(String modelNo) {
		ModelNo = modelNo;
	}

	public String getMedName() {
		return MedName;
	}

	public void setMedName(String medName) {
		MedName = medName;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public String getManufDate() {
		return ManufDate;
	}

	public void setManufDate(String manufDate) {
		ManufDate = manufDate;
	}

	public String getExpDate() {
		return ExpDate;
	}

	public void setExpDate(String expDate) {
		ExpDate = expDate;
	}

	public String getCOO() {
		return COO;
	}

	public void setCOO(String cOO) {
		COO = cOO;
	}

	public String getInStock() {
		return InStock;
	}

	public void setInStock(String inStock) {
		InStock = inStock;
	}

	public String getId() {
		return Id;
	}
	
	public void setId(String id) {
		Id = id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getHonorific() {
		return Honorific;
	}

	public void setHonorific(String honorific) {
		Honorific = honorific;
	}

	public String getRegId() {
		return RegId;
	}

	public void setRegId(String regId) {
		RegId = regId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDAge() {
		return DAge;
	}

	public void setDAge(String dAge) {
		DAge = dAge;
	}

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	public String getSpecialization() {
		return Specialization;
	}

	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}

	public String getExperience() {
		return Experience;
	}

	public void setExperience(String experience) {
		Experience = experience;
	}

	public String getArchievements() {
		return Archievements;
	}

	public void setArchievements(String archievements) {
		Archievements = archievements;
	}

	public String getHouseNo() {
		return HouseNo;
	}

	public void setHouseNo(String houseNo) {
		HouseNo = houseNo;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getZipCode() {
		return ZipCode;
	}

	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}

	public String getFees() {
		return Fees;
	}

	public void setFees(String fees) {
		Fees = fees;
	}

	public String getDMobile() {
		return DMobile;
	}

	public void setDMobile(String dMobile) {
		DMobile = dMobile;
	}


	public String getPhoneWorkPlace() {
		return PhoneWorkPlace;
	}

	public void setPhoneWorkPlace(String phoneWorkPlace) {
		PhoneWorkPlace = phoneWorkPlace;
	}

	public String getPhoneResidence() {
		return PhoneResidence;
	}

	public void setPhoneResidence(String phoneResidence) {
		PhoneResidence = phoneResidence;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return Occupation;
	}

	public void setOccupation(String occupation) {
		Occupation = occupation;
	}

	public String getReligion() {
		return Religion;
	}

	public void setReligion(String religion) {
		Religion = religion;
	}

	public String getMaritalStatus() {
		return MaritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getRD() {
		return RD;
	}

	public void setRD(String rD) {
		RD = rD;
	}

	public String getLLD() {
		return LLD;
	}

	public void setLLD(String lLD) {
		LLD = lLD;
	}

	public String getPID() {
		return PID;
	}

	public void setPID(String pID) {
		PID = pID;
	}

	public String getDrRegId() {
		return DrRegId;
	}

	public void setDrRegId(String drRegId) {
		DrRegId = drRegId;
	}

	public String getM1() {
		return M1;
	}

	public void setM1(String m1) {
		M1 = m1;
	}

	public String getM2() {
		return M2;
	}

	public void setM2(String m2) {
		M2 = m2;
	}

	public String getM3() {
		return M3;
	}

	public void setM3(String m3) {
		M3 = m3;
	}

	public String getM4() {
		return M4;
	}

	public void setM4(String m4) {
		M4 = m4;
	}

	public String getM5() {
		return M5;
	}

	public void setM5(String m5) {
		M5 = m5;
	}

	public String getD1() {
		return D1;
	}

	public void setD1(String d1) {
		D1 = d1;
	}

	public String getD2() {
		return D2;
	}

	public void setD2(String d2) {
		D2 = d2;
	}

	public String getD3() {
		return D3;
	}

	public void setD3(String d3) {
		D3 = d3;
	}

	public String getD4() {
		return D4;
	}

	public void setD4(String d4) {
		D4 = d4;
	}

	public String getD5() {
		return D5;
	}

	public void setD5(String d5) {
		D5 = d5;
	}

	public String getQ1() {
		return Q1;
	}

	public void setQ1(String q1) {
		Q1 = q1;
	}

	public String getQ2() {
		return Q2;
	}

	public void setQ2(String q2) {
		Q2 = q2;
	}

	public String getQ3() {
		return Q3;
	}

	public void setQ3(String q3) {
		Q3 = q3;
	}

	public String getQ4() {
		return Q4;
	}

	public void setQ4(String q4) {
		Q4 = q4;
	}

	public String getQ5() {
		return Q5;
	}

	public void setQ5(String q5) {
		Q5 = q5;
	}

	public String getW1() {
		return W1;
	}

	public void setW1(String w1) {
		W1 = w1;
	}

	public String getW2() {
		return W2;
	}

	public void setW2(String w2) {
		W2 = w2;
	}

	public String getW3() {
		return W3;
	}

	public void setW3(String w3) {
		W3 = w3;
	}

	public String getW4() {
		return W4;
	}

	public void setW4(String w4) {
		W4 = w4;
	}

	public String getW5() {
		return W5;
	}

	public void setW5(String w5) {
		W5 = w5;
	}

	public String getL1() {
		return L1;
	}

	public void setL1(String l1) {
		L1 = l1;
	}

	public String getL2() {
		return L2;
	}

	public void setL2(String l2) {
		L2 = l2;
	}

	public String getL3() {
		return L3;
	}

	public void setL3(String l3) {
		L3 = l3;
	}

	public String getL4() {
		return L4;
	}

	public void setL4(String l4) {
		L4 = l4;
	}

	public String getL5() {
		return L5;
	}

	public void setL5(String l5) {
		L5 = l5;
	}

	public String getL6() {
		return L6;
	}

	public void setL6(String l6) {
		L6 = l6;
	}

	public String getL7() {
		return L7;
	}

	public void setL7(String l7) {
		L7 = l7;
	}

	public String getL8() {
		return L8;
	}

	public void setL8(String l8) {
		L8 = l8;
	}

	public String getL9() {
		return L9;
	}

	public void setL9(String l9) {
		L9 = l9;
	}

	public String getR1() {
		return R1;
	}

	public void setR1(String r1) {
		R1 = r1;
	}

	public String getR2() {
		return R2;
	}

	public void setR2(String r2) {
		R2 = r2;
	}

	public String getS1() {
		return S1;
	}

	public void setS1(String s1) {
		S1 = s1;
	}
}
