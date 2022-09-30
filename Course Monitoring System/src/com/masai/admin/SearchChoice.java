package com.masai.admin;

import java.util.Scanner;

import com.masai.custom.ConsoleColors;

public class SearchChoice {
	
	public static void searchOptions() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println();
			System.out.println(ConsoleColors.CYAN+"1. Search By Faculty Id");
			System.out.println("2. Search By Name");
			System.out.println("3. View All Data");
			System.out.println("4. Back" );
			System.out.println("5. Close"+ConsoleColors.RESET);
			
			int ch = sc.nextInt();
				
			if(ch == 1) {
					
				SearchFacultyByInt.searchById();
					
			}else if(ch == 2) {
					
				SearchFacultyByName.searchByName();
					
			}else if(ch == 3) {
					
				GetAllFaculties.viewAll();
					
			}else if(ch == 4) {
				
				break;
				
			}else if(ch == 5) {
				System.out.println(ConsoleColors.BANANA_YELLOW+"See You Soon..."+ConsoleColors.RESET);
				System.exit(0);
				
			}
			else {
					
				System.out.println(ConsoleColors.RED+"Wrong Input Try Again"+ConsoleColors.RESET);
			}
				
		}
		
		
	}
	
}
