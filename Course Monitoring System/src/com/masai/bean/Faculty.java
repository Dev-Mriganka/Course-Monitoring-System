package com.masai.bean;

public class Faculty {
	
	private int facultyId;
	private String fname;
	private String lname;
	private String address;
	private String state;
	private String pin;
	private String mobile;
	private String email;
	private String username;
	private String password;
	
	
	public Faculty() {
		super();
	}
	

	public Faculty(int facultyId, String fname, String lname, String address, String state, String pin, String mobile,
			String email, String username) {
		super();
		this.facultyId = facultyId;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.state = state;
		this.pin = pin;
		this.mobile = mobile;
		this.email = email;
		this.username = username;
	}


	public Faculty(String fname, String lname, String address, String state, String pin,
			String mobile, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.state = state;
		this.pin = pin;
		this.mobile = mobile;
		this.email = email;
	}




	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	
	public String getPin() {
		return pin;
	}
	
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	
	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}


	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", fname=" + fname + ", lname=" + lname
				+ ", address=" + address + ", state=" + state + ", pin=" + pin + ", mobile=" + mobile
				+ ", email=" + email + ", username=" + username+ " ] ";
	}
	
	
	
}
