package com.masai.course;

import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.dao.CourseDao;
import com.masai.dao.CourseDaoImpl;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.InputException;

public class DeleteCourse {
	
public static void deleteCourse() throws InputException {
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println(ConsoleColors.CYAN+"Enter Name of Course"+ConsoleColors.RESET);
			String cName = sc.next();
			
			CourseDao dao = new CourseDaoImpl();
			
			try {
				String res = dao.deleteBatch(cName);
				System.out.println();
				System.out.println(res);
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
