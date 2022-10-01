package com.masai.faculty;

import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.exceptions.InputException;

public class FacultyChoice {
	
	public static void facultyOptions() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println(ConsoleColors.CYAN+"1. Add Faculty");
			System.out.println("2. Update Faculty");
			System.out.println("3. Search Faculty");
			System.out.println("4. Delete Faculty");
			System.out.println("5. Back");
			System.out.println("6. Close"+ConsoleColors.RESET);
			
			
			int ch = sc.nextInt();
		
			if(ch == 1) {
				try {
					AddFaculty.addFacultyMtd();
					
				} catch (InputException e) {
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					
				}
				
			}else if(ch == 2) {
				UpdateChoice.updateOptions();
				
			}else if(ch == 3) {
				SearchChoice.searchOptions();
				
			}else if(ch == 4) {
				try {
					DeleteFaculty.deleteFaculty();
				} catch (InputException e) {
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
				}
				
			}else if(ch== 6) {
				System.out.println();
				System.out.println(ConsoleColors.BANANA_YELLOW+"See You Soon..."+ConsoleColors.RESET);
				System.exit(0);
				
			}else if(ch == 5) {
				break;
				
			}else {
				System.out.println();
				System.out.println(ConsoleColors.RED+"Wrong Input Try Again"+ConsoleColors.RESET);
				System.out.println();
				
			}
		}
		
	}
	
}
