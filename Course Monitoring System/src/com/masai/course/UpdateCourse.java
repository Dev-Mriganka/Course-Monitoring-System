package com.masai.course;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.dao.CourseDao;
import com.masai.dao.CourseDaoImpl;
import com.masai.exceptions.CourseException;

public class UpdateCourse {

	public static void updateCourse(String name){
		
		try {
		
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			boolean flag = true;
			boolean flag2 = true;
			
			while(flag) {
				
				String str = "";
				
				while(true) {
					
					System.out.println(ConsoleColors.CYAN+"What do you want to update?");
					System.out.println("1. Course Name");
					System.out.println("2. Course Fee");
					System.out.println("3. Course Description");
					System.out.println("4. Back");
					System.out.println("5. Close" +ConsoleColors.RESET);
					
					int ch = sc.nextInt();
					
					if(ch == 4) {
						flag = false;
						flag2 = false;
						break;
						
					}else if(ch== 5) {
						System.out.println();
						System.out.println(ConsoleColors.BANANA_YELLOW+"See You Soon..."+ConsoleColors.RESET);
						System.exit(0);	
					}
					
				
					if(ch == 1) {
						str = "courseName";
						break;
					}else if(ch == 2) {
						str = "courseFee";
						break;
					}else if(ch == 3) {
						str = "courseDesc";
						break;
					}else {
						System.out.println();
						System.out.println(ConsoleColors.RED+"Wrong Input Try Again"+ConsoleColors.RESET);
						System.out.println();
						flag2 = false;
						break;
					}
				}
				if(flag2) {
					sc.nextLine();
					System.out.println("Enter New Entry :");
					String set = sc.nextLine();
					
					CourseDao dao = new CourseDaoImpl();
					
					String result;
					try {
						result = dao.updateCourseDetails(str, set, name);
						System.out.println();
						System.out.println(result);
						System.out.println();
						
					} catch (CourseException e) {
						
						System.out.println();
						System.out.println(ConsoleColors.RED_BACKGROUND+ e.getMessage()+ConsoleColors.RESET);
						System.out.println();
					}
				}
				
				
				while(flag2) {
					System.out.println(ConsoleColors.CYAN+"Want to update anything else?(y/n)"+ConsoleColors.RESET);
					String choice = sc.next();
					
					if(choice.equalsIgnoreCase("y")) {
						break;
					}else if(choice.equalsIgnoreCase("n")){
						flag = false;
						break;
					}else {
						System.out.println();
						System.out.println(ConsoleColors.RED+"Wrong Input...!"+ConsoleColors.RESET);
						System.out.println();
					}
				}
			}
			
		}catch(InputMismatchException e) {
			System.out.println();
			System.out.println(ConsoleColors.RED+"Wrong Input Try Again!"+ConsoleColors.RESET);
			System.out.println();
			updateCourse(name);
		}

	}

}
