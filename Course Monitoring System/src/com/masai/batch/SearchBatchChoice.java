package com.masai.batch;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.exceptions.InputException;

public class SearchBatchChoice {
	
	public static void batchSearchOptions() {
		
		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println(ConsoleColors.CYAN+"1. Search By Batch Id");
				System.out.println("2. Search By Course Name");
				System.out.println("3. View All Data");
				System.out.println("4. Back" );
				System.out.println("5. Close"+ConsoleColors.RESET);
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					try {
						SearchBatchById.searchBatchById();
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
					
				}else if(ch == 2) {				
					try {
						SearchBatchByName.searchBatchByName();
						
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
					
				}else if(ch == 3) {
					ViewAllBatch.viewAllBatch();
					
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
		}catch(InputMismatchException ie) {
			System.out.println();
			System.out.println(ConsoleColors.RED+"Wrong Input Try Again!"+ConsoleColors.RESET);
			System.out.println();
			batchSearchOptions();
			
		}
		
	}
	
}
