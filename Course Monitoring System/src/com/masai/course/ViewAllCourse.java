package com.masai.course;

import java.util.List;

import com.masai.bean.Course;
import com.masai.custom.ConsoleColors;
import com.masai.dao.CourseDao;
import com.masai.dao.CourseDaoImpl;
import com.masai.exceptions.CourseException;

public class ViewAllCourse {
	
	public static void viewAllCourse() {
		
		CourseDao dao = new CourseDaoImpl();
		
		try {
			List<Course> courses = dao.getAllCourse();
			
			courses.forEach( c -> {
				
				System.out.println();
				System.out.println(ConsoleColors.ORANGE+"Course Id : "+ c.getCourseId());
				System.out.println("Course Name : " + c.getCourseName());
				System.out.println("Course Fee : " + c.getCourseFee() + " Rs.");
				System.out.println("Course Description : " + c.getCourseDesc());
				System.out.println("------------------------------"+ConsoleColors.RESET);
				
			});
			System.out.println();
			
		} catch (CourseException e) {
			System.out.println();
			System.out.println(ConsoleColors.RED_BACKGROUND+ e.getMessage()+ConsoleColors.RESET);
			System.out.println();
		}
		
	}
	
}
