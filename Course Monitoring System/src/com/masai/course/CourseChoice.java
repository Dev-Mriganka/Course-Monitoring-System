package com.masai.course;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.exceptions.InputException;

public class CourseChoice {
	
	public static void courseOptions() {
		
		
		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println(ConsoleColors.CYAN+"1. Add Course");
				System.out.println("2. Update Course");
				System.out.println("3. Search Course");
				System.out.println("4. Delete Course");
				System.out.println("5. Back");
				System.out.println("6. Close"+ConsoleColors.RESET);
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					try {
						AddCourse.addCourceMtd();
						
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
						
					}
					
				}else if(ch == 2) {
					
					while(true) {
						System.out.println(ConsoleColors.CYAN+"Enter name of Course"+ConsoleColors.RESET);
						String name = sc.next();
						
						boolean flag = SearchCourseByName.searchByName(name);
						if(flag) {					
							UpdateCourse.updateCourse(name);
							break;
						}else {
							System.out.println();
							System.out.println(ConsoleColors.RED+"Course Name Doesn't Exist!"+ConsoleColors.RESET);
							System.out.println();
						}
					}
					
				}else if(ch == 3) {
					CourseSearchChoice.courseSearchOptions();
					
				}else if(ch == 4) {
					try {
						DeleteCourse.deleteCourse();
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
					
				}else if(ch == 5) {
					break;
					
				}else if(ch == 6) {
					System.out.println();
					System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"See You Soon..."+ConsoleColors.RESET);
					System.exit(0);
					
				}else {
					System.out.println();
					System.out.println(ConsoleColors.RED+"Wrong Input Try Again!"+ConsoleColors.RESET);
					System.out.println();
					
				}
				
			}
			System.out.println();
		}catch(InputMismatchException ie) {
			System.out.println();
			System.out.println(ConsoleColors.RED+"Wrong Input Try Again!"+ConsoleColors.RESET);
			System.out.println();
			courseOptions();
			
		}
		
	}
	
}
