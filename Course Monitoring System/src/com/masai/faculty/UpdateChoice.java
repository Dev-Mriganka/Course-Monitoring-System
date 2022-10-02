package com.masai.faculty;


import java.util.Scanner;

import com.masai.custom.ConsoleColors;



public class UpdateChoice {
	
	public static void updateOptions() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {	

			System.out.println(ConsoleColors.CYAN+"1. Update By Id");
			System.out.println("2. Update By Name");
			System.out.println("3. Back");
			System.out.println("4. Close" +ConsoleColors.RESET);
			
			int ch = sc.nextInt();
		
			if(ch == 1) {
				try {
					System.out.println(ConsoleColors.CYAN+"Enter id of Faculty"+ConsoleColors.RESET);
					int id = sc.nextInt();
					
					UpdateFacultyDetails.UpdateById(id);
				}catch(Exception e) {
					System.out.println();	
					System.out.println(ConsoleColors.RED+"Wrong Input Try Again"+ConsoleColors.RESET);
					System.out.println();
					updateOptions();
				}
				
			}else if(ch == 2) {
				if(SearchFacultyByName.searchByName()) {
					
					try {
						System.out.println(ConsoleColors.CYAN+"Enter id of Faculty"+ConsoleColors.RESET);
						int id = sc.nextInt();
						UpdateFacultyDetails.UpdateById(id);
					}catch(Exception e) {
						System.out.println();	
						System.out.println(ConsoleColors.RED+"Wrong Input Try Again"+ConsoleColors.RESET);
						System.out.println();
						updateOptions();
					}
				}else {
					updateOptions();
				}
				
			}else if(ch== 4) {
				System.out.println(ConsoleColors.BANANA_YELLOW+"See You Soon..."+ConsoleColors.RESET);
				System.exit(0);
				
			}else if(ch == 3) {
				break;
				
			}else {
				
				System.out.println(ConsoleColors.RED+"Wrong Input Try Again"+ConsoleColors.RESET);
			}
			
		}
		
		
	}
	
}
