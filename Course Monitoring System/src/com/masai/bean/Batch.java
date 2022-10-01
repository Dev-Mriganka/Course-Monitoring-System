package com.masai.bean;


public class Batch {
	
	private String batchId;
	private int courseId;
	private int facultyId;
	private String facultyName;
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}


	private int noOfStudents;
	private String batchstartDate;
	private String duration;
	
	
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
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
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
	
	
	
	public Batch() {
		super();
	}
	
	
	public Batch(String batchId, int courseId, int facultyId, int noOfStudents, String batchstartDate,
			String duration) {
		super();
		this.batchId = batchId;
		this.courseId = courseId;
		this.facultyId = facultyId;
		this.noOfStudents = noOfStudents;
		this.batchstartDate = batchstartDate;
		this.duration = duration;
	}
	
	
	
	public Batch(String batchId, int courseId, int facultyId, String facultyName, int noOfStudents,
			String batchstartDate, String duration) {
		super();
		this.batchId = batchId;
		this.courseId = courseId;
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.noOfStudents = noOfStudents;
		this.batchstartDate = batchstartDate;
		this.duration = duration;
	}
	
	
	public Batch(int courseId, int noOfStudents, String batchstartDate, String duration) {
		super();
		this.courseId = courseId;
		this.noOfStudents = noOfStudents;
		this.batchstartDate = batchstartDate;
		this.duration = duration;
	}
	
	
	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", courseId=" + courseId + ", facultyId=" + facultyId
				+ ", noOfStudents=" + noOfStudents + ", batchstartDate=" + batchstartDate + ", duration="
				+ duration + "]";
	}
	
	
}
