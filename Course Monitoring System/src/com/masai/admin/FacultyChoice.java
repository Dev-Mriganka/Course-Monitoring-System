package com.masai.admin;

import java.util.Scanner;

import com.masai.custom.ConsoleColors;

public class FacultyChoice {
	
	public static void facultyOptions() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println(ConsoleColors.CYAN+"1. Add Faculty");
			System.out.println("2. Update Faculty");
			System.out.println("3. Search Faculty");
			System.out.println("4. Back");
			System.out.println("5. Close"+ConsoleColors.RESET);
			System.out.println();
			
			int ch = sc.nextInt();
		
			if(ch == 1) {
				AddFaculty.addFacultyMtd();
				
			}else if(ch == 2) {
				UpdateChoice.updateOptions();
				
			}else if(ch == 3) {
				SearchChoice.searchOptions();
				
			}else if(ch== 5) {
				System.out.println(ConsoleColors.BANANA_YELLOW+"See You Soon..."+ConsoleColors.RESET);
				System.exit(0);
				
			}else if(ch == 4) {
				break;
				
			}else {
				
				System.out.println(ConsoleColors.RED+"Wrong Input Try Again"+ConsoleColors.RESET);
			}
			
		}
		
	}
	
}
