package com.masai.admin;


import java.util.Scanner;



public class UpdateChoice {
	
	public static void updateOptions() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {	
			System.out.println();
			System.out.println("1. Update By Id");
			System.out.println("2. Update By Name");
			System.out.println("3. Back");
			System.out.println("4. Close");
			
			int ch = sc.nextInt();
		
			if(ch == 1) {
				System.out.println("Enter id of Faculty");
				int id = sc.nextInt();
				
				UpdateFacultyDetails.UpdateById(id);
				
			}else if(ch == 2) {
				SearchFacultyByName.searchByName();
				
				System.out.println("Enter id of Faculty");
				int id = sc.nextInt();
				
				UpdateFacultyDetails.UpdateById(id);
				
			}else if(ch== 4) {
				System.out.println("See You Soon...");
				System.exit(0);
				
			}else if(ch == 3) {
				break;
				
			}else {
				
				System.out.println("Wrong Input Try Again");
			}
			
		}
		
		
	}
	
}
