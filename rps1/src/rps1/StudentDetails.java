package rps1;

//This file explains the Student's details

public class StudentDetails {
final private String roll; 
final private String ayr; 
final private String fname; 
final private String mname ;
final private String lname ;
final private String id ;
final private int dcode ;
final private String dob;
final private String address; 
final private String phone ;
final private String mail ;
final private String gender; 
final private int sem; 
final private String clg; 
StudentDetails(String roll,String ayr,String fname,String mname,String lname,String id,int dcode,String dob,String address,String phone,String mail,String gender,int sem,String clg){
   this.roll=roll;
   this.ayr=ayr; 
   this.fname = fname; 
   this.mname= mname; 
   this.lname= lname; 
   this.id=id; 
   this.dcode= dcode ;
   this.dob= dob; 
   this.address =address; 
   this.phone=phone; 
   this.mail= mail; 
   this.gender=gender; 
   this.sem=sem; 
   this.clg=clg;
}

public String getStudentRoll() {
   return roll;
}

public String getStudentFName() {
   return fname;
}

public String getStudentMName() {
	   return mname;
	}

public String getStudentLName() {
	   return lname;
	}

public String getStudentAdmYr() {
	   return ayr;
	}

public int getDCode() {
	   return dcode;
	}

public String getStudentPhone() {
	   return phone;
	}

public String getStudentCollege() {
	   return clg;
	}

public String getDob() {
	   return dob;
	}

public String getStudentGender() {
	   return gender;
	}

public String getStudentMail() {
	   return mail;
	}
public String getStudentAddress() {
   return address;
}

public int getStudentSem() {
	   return sem;
	}

public String getId() {
	   return id;
	}
}
