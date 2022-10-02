package com.masai.admin;

import java.util.Scanner;

import com.masai.batch.BatchChoice;
import com.masai.batch.GenerateReport;
import com.masai.course.CourseChoice;
import com.masai.courseplan.CoursePlanChoice;
import com.masai.courseplan.ViewAllPlanDayWise;
import com.masai.custom.ConsoleColors;
import com.masai.faculty.FacultyChoice;

public class AdminChoice {
	
	public static void adminOption() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println(ConsoleColors.CYAN+"1. Courses");
			System.out.println("2. Faculty");
			System.out.println("3. Batch");
			System.out.println("4. Course Plan");
			System.out.println("5. View Day wise Planner");
			System.out.println("6. Generate Report");
			System.out.println("7. Log Out");
			System.out.println("8. Close the App"+ConsoleColors.RESET);
			
			
			int ch = sc.nextInt();
		
			if(ch == 1) {
				CourseChoice.courseOptions();

			}else if(ch == 2) {
				FacultyChoice.facultyOptions();

			}else if(ch == 3) {
				BatchChoice.facultyOptions();
	
			}else if(ch == 4) {
				CoursePlanChoice.CourseOptions();

			}else if(ch == 5) {
				ViewAllPlanDayWise.viewAllPlan();

			}else if(ch == 6) {
				GenerateReport.viewAllBatch();

			}else if(ch== 8) {
				System.out.println();
				System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"See You Soon..."+ConsoleColors.RESET);
				System.exit(0);
				
			}else if(ch == 7) {
				break;
				
			}
			else {
				System.out.println();
				System.out.println(ConsoleColors.RED+"Wrong Input Try Again!"+ConsoleColors.RESET);
				System.out.println();
				adminOption();
			}
			
		}
		
		
	}
	
}
