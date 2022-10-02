package com.masai.dao;

import java.util.List;

import com.masai.bean.CoursePlan;
import com.masai.exceptions.CoursePlanException;

public interface CourseplanDao {
	
	public String addCoursePlan(String batchId, int dayNo) throws CoursePlanException;
	
	public String updateStatus(String batchId, int dayNo) throws CoursePlanException;
	
	public String updateStatusAdmin(String batchId, int dayNo) throws CoursePlanException;
	
	public String updateTopic(String batchId, int dayNo, String topic) throws CoursePlanException;
	
	public String updateDate(String batchId, int dayNo, int newDay) throws CoursePlanException;
	
	public String deleteStatus(String batchId, int dayNo) throws CoursePlanException;
	
	public List<CoursePlan> viewAllCoursePlanDateWise() throws CoursePlanException;
	
	public List<CoursePlan> viewFacultyCoursePlan(int facultyId) throws CoursePlanException;
	
	public List<CoursePlan> viewCourseByDate(String date) throws CoursePlanException;
}
