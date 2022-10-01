package com.masai.course;

import java.util.Scanner;

import com.masai.bean.Course;
import com.masai.custom.ConsoleColors;
import com.masai.dao.CourseDao;
import com.masai.dao.CourseDaoImpl;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.InputException;

public class SearchCourse {

	public static void searchByCourse() throws InputException{
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println(ConsoleColors.CYAN+"Enter Name of Course"+ConsoleColors.RESET);
			String cname = sc.next();
			
			
			CourseDao dao = new CourseDaoImpl();
			
			try {
				Course c = dao.searchCourse(cname);
				System.out.println();
				System.out.println(ConsoleColors.ORANGE+"Course Id : "+ c.getCourseId());
				System.out.println("Course Name : " + c.getCourseName());
				System.out.println("Course Fee : " + c.getCourseFee() + " Rs.");
				System.out.println("Course Description : " + c.getCourseDesc());
				System.out.println("------------------------------"+ConsoleColors.RESET);
				System.out.println();
				
			} catch (CourseException e) {
				System.out.println();
				System.out.println(ConsoleColors.RED_BACKGROUND+ e.getMessage()+ConsoleColors.RESET);
				System.out.println();
			}
		}catch(Exception e) {
			throw new InputException(ConsoleColors.RED+"Please Enter Right Input"+ConsoleColors.RESET);
			
		}
		
	}

}
