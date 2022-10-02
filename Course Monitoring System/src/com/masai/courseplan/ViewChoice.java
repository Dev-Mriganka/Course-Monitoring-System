package com.masai.courseplan;

import java.util.Scanner;

import com.masai.custom.ConsoleColors;

public class ViewChoice {
	
public static void viewOptions() {
		
		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println(ConsoleColors.CYAN+"1. View All Plan Day Wise");
				System.out.println("2. Search By Faculty");
				System.out.println("3. Search By Date");
				System.out.println("4. Back");
				System.out.println("5. Close"+ConsoleColors.RESET);
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					ViewAllPlanDayWise.viewAllPlan();
					
				}else if(ch == 2) {
					System.out.println("Enter Faculty ID: ");
					int facultyId = sc.nextInt();
					if(CheckFacultyId.checkFacultyId(facultyId)) {	
						ViewFacultyCoursePlan.viewByFaculty(facultyId);
						
					}else {
						System.out.println();
						System.out.println(ConsoleColors.RED+"No Faculty Present with FacultyId "+facultyId+ConsoleColors.RESET);
						System.out.println();
					}
					
				}else if(ch == 3) {
					System.out.println("Enter Date(YYYY-MM-DD): ");
					String date = sc.next();
					ViewPlanByDate.viewAllPlan(date);
					
				}else if(ch == 4) {
					break;
					
				}else if(ch == 5) {
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
			viewOptions();
		}
		
	}
	
}
