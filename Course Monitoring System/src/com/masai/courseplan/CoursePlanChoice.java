package com.masai.courseplan;

import java.util.Scanner;

import com.masai.custom.ConsoleColors;

public class CoursePlanChoice {
	

	public static void CourseOptions() {
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println(ConsoleColors.CYAN+"1. Add Course Plan");
				System.out.println("2. Update Course Plan");
				System.out.println("3. View Course Plan");
				System.out.println("4. Delete Course Plan");
				System.out.println("5. Back");
				System.out.println("6. Close"+ConsoleColors.RESET);
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					System.out.println("Enter Faculty ID: ");
					int facultyId = sc.nextInt();
					if(CheckFacultyId.checkFacultyId(facultyId)) {					
						AddCoursePlanByFaculty.addCoursePlanMtd(facultyId);
						
					}else {
						System.out.println();
						System.out.println(ConsoleColors.RED+"No Faculty Present with FacultyId "+facultyId+ConsoleColors.RESET);
						System.out.println();
					}		
					
				}else if(ch == 2) {
					UpdateOptions.CourseOptions();
					
				}else if(ch == 3) {
					ViewChoice.viewOptions();
					
				}else if(ch == 4) {
					System.out.println("Enter Faculty ID: ");
					int facultyId = sc.nextInt();
					
					if(CheckFacultyId.checkFacultyId(facultyId)) {
						DeletePlan.deletePlan(facultyId);
					}else {
						System.out.println();
						System.out.println(ConsoleColors.RED+"No Faculty Present with FacultyId "+facultyId+ConsoleColors.RESET);
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
		}catch (Exception e) {
			System.out.println();
			System.out.println(ConsoleColors.RED+"Please Enter Right Input"+ConsoleColors.RESET);
			System.out.println();
			CourseOptions();
			
		}
		
	}
	
}
