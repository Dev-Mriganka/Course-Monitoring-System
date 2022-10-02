package com.masai.facultyOptions;

import java.util.Scanner;

import com.masai.bean.Faculty;
import com.masai.courseplan.UpdateStatus;
import com.masai.courseplan.UpdateTopic;
import com.masai.courseplan.ViewFacultyCoursePlan;
import com.masai.custom.ConsoleColors;

public class FacultyLoginOption {
	
	public static void facultyOption(Faculty faculty) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println(ConsoleColors.CYAN+"1. Fill Day Planner");
			System.out.println("2. Update Status Day Planner");
			System.out.println("3. View Course Plan");
			System.out.println("4. Settings");
			System.out.println("5. Log Out");
			System.out.println("6. Close the App"+ConsoleColors.RESET);
			
			int ch = sc.nextInt();
			
			if(ch == 1) {
				UpdateTopic.updateTopic(faculty.getFacultyId());
					
			}else if(ch == 2) {
				UpdateStatus.updateStatus(faculty.getFacultyId());

			}else if(ch == 3) {
				ViewFacultyCoursePlan.viewByFaculty(faculty.getFacultyId());
	
			}else if(ch == 4) {
				FacultySettings.facultySettings(faculty);

			}else if(ch== 6) {
				System.out.println();
				System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"See You Soon..."+ConsoleColors.RESET);
				System.exit(0);
				
			}else if(ch == 5) {
				break;
				
			}
			else {
				System.out.println();
				System.out.println(ConsoleColors.RED+"Wrong Input Try Again!"+ConsoleColors.RESET);
				System.out.println();
				facultyOption(faculty);
			}
			
		}
		
	}
	
}
