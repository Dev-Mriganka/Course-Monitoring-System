package com.masai.admin;

import java.util.Scanner;

public class SearchChoice {
	
	public static void searchOptions() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println();
			System.out.println("1. Search By Id");
			System.out.println("2. Search By Name");
			System.out.println("3. View All Data");
			System.out.println("4. Back");
			
			int ch = sc.nextInt();
				
			if(ch == 1) {
					
				SearchFacultyByInt.searchById();
					
			}else if(ch == 2) {
					
				SearchFacultyByName.searchByName();
					
			}else if(ch == 3) {
					
				GetAllFaculties.viewAll();
					
			}else if(ch == 4) {
				
				break;
				
			}else {
					
				System.out.println("Wrong Input Try Again");
			}
				
		}
		
		
	}
	
}
