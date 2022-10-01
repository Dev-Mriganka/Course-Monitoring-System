package com.masai.batch;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.exceptions.FacultyException;
import com.masai.exceptions.InputException;

public class BatchChoice {
	
	public static void facultyOptions() {
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println(ConsoleColors.CYAN+"1. Add Batch");
				System.out.println("2. Update Batch");
				System.out.println("3. Search Batch");
				System.out.println("4. Delete Batch");
				System.out.println("5. Allocate Faculty");
				System.out.println("6. Back");
				System.out.println("7. Close"+ConsoleColors.RESET);
				
				int ch = sc.nextInt();
				
				if(ch == 1) {
					try {
						AddBatch.addBatchMtd();
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
				}else if(ch == 2) {
					
					System.out.println(ConsoleColors.CYAN+"Enter name of Course"+ConsoleColors.RESET);
					String batchId = sc.next();
					
					UpdateBatch.updateCourse(batchId);
					
				}else if(ch == 3) {
					SearchBatchChoice.batchSearchOptions();
					
				}else if(ch == 4) {
					try {
						DeleteBatch.deleteBatch();
					} catch (InputException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
					
				}else if(ch == 5) {
					try {
						AllocateFaculty.allocateFaculty();
					} catch (FacultyException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
					}
					
				}else if(ch == 6) {
					break;
					
				}else if(ch == 7) {
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
			facultyOptions();
			
		}
		
	}
	
}
