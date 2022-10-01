package com.masai.course;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.exceptions.InputException;

public class CourseSearchChoice {
	
	public static void courseSearchOptions() {
		
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
				
			while(true) {
				
				System.out.println(ConsoleColors.CYAN+"1. Search By Course");
				System.out.println("2. View All Course");
				System.out.println("3. Back" );
				System.out.println("4. Close"+ConsoleColors.RESET);
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					try {
						SearchCourse.searchByCourse();
						
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
					
				}else if(ch == 2) {
					ViewAllCourse.viewAllCourse();
					
				}else if(ch == 3) {
					break;
					
				}else if(ch == 4) {
					System.out.println();
					System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"See You Soon..."+ConsoleColors.RESET);
					System.exit(0);
					
				}else {
					System.out.println();
					System.out.println(ConsoleColors.RED+"Wrong Input Try Again!"+ConsoleColors.RESET);
					System.out.println();
					
				}
			}
			
		}catch(InputMismatchException ie) {
			System.out.println();
			System.out.println(ConsoleColors.RED+"Wrong Input Try Again!"+ConsoleColors.RESET);
			System.out.println();
			courseSearchOptions();
			
		}
		
	}
}
