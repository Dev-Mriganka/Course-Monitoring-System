package com.masai.bean;

public class Course {
	
	private int courseId;
	private String courseName;
	private int courseFee;
	private String courseDesc;
	
	
	public Course() {
		super();
	}
	
	
	public Course(int courseId, String courseName, int courseFee, String courseDesc) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.courseDesc = courseDesc;
	}


	public Course(String courseName, int courseFee, String courseDesc) {
		super();
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.courseDesc = courseDesc;
	}

	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	
	public int getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}

	
	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", fee=" + courseFee + ", courseDescription="
				+ courseDesc + "]";
	}
	
	
}
