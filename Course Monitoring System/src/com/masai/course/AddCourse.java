package com.masai.course;

import java.util.Scanner;

import com.masai.bean.Course;
import com.masai.custom.ConsoleColors;
import com.masai.dao.CourseDao;
import com.masai.dao.CourseDaoImpl;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.InputException;

public class AddCourse {

	public static void addCourceMtd() throws InputException{

		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println(ConsoleColors.CYAN+"Enter Name of the Course"+ConsoleColors.RESET);
			String cname = sc.next();
			
			System.out.println(ConsoleColors.CYAN+"Enter the Course Fee"+ConsoleColors.RESET);
			int cfee = sc.nextInt();
			
			sc.nextLine();
			System.out.println(ConsoleColors.CYAN+"Enter Couse Description"+ConsoleColors.RESET);
			String cdesc = sc.nextLine();
			
			Course course = new Course(cname, cfee, cdesc);
			
			CourseDao dao = new CourseDaoImpl();
			
			String res;
			try {
				res = dao.addCourse(course);
				System.out.println();
				System.out.println(res);
				System.out.println();
				
			} catch (CourseException ce) {
				System.out.println();
				System.out.println(ConsoleColors.RED_BACKGROUND+ce.getMessage()+ConsoleColors.RESET);
				System.out.println();
			}
			
		}catch(Exception e) {
			throw new InputException(ConsoleColors.RED+"Please Enter Right Input"+ConsoleColors.RESET);
			
		}
		
		
	}

}
