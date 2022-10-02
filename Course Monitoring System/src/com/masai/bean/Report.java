package com.masai.bean;

public class Report {
	
	private String batchId;
	private int courseId;
	private String facultyFname;
	private int noOfStudents; 
	private String batchstartDate; 
	private String duration;
	private int planned;
	private int completed;
	
	
	public Report(String batchId, int courseId, String facultyFname, int noOfStudents, String batchstartDate,
			String duration, int planned, int completed) {
		super();
		this.batchId = batchId;
		this.courseId = courseId;
		this.facultyFname = facultyFname;
		this.noOfStudents = noOfStudents;
		this.batchstartDate = batchstartDate;
		this.duration = duration;
		this.planned = planned;
		this.completed = completed;
	}


	public String getBatchId() {
		return batchId;
	}


	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getFacultyFname() {
		return facultyFname;
	}


	public void setFacultyFname(String facultyFname) {
		this.facultyFname = facultyFname;
	}


	public int getNoOfStudents() {
		return noOfStudents;
	}


	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}


	public String getBatchstartDate() {
		return batchstartDate;
	}


	public void setBatchstartDate(String batchstartDate) {
		this.batchstartDate = batchstartDate;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public int getPlanned() {
		return planned;
	}


	public void setPlanned(int planned) {
		this.planned = planned;
	}


	public int getCompleted() {
		return completed;
	}


	public void setCompleted(int completed) {
		this.completed = completed;
	}
	
	
	
}
