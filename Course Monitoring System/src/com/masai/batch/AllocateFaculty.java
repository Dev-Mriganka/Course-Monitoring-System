package com.masai.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.dao.BatchDao;
import com.masai.dao.BatchDaoImpl;
import com.masai.exceptions.BatchException;
import com.masai.exceptions.FacultyException;
import com.masai.utility.DBconn;

public class AllocateFaculty {

	public static void allocateFaculty() throws FacultyException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		

		try(Connection conn = DBconn.provideConnection()){
			System.out.println(ConsoleColors.CYAN+"Enter the Faculty Id :"+ConsoleColors.RESET);
			int set = sc.nextInt();
			
			PreparedStatement ps = conn.prepareStatement("select * from faculty where facultyId = ?");
			
			ps.setInt(1, set);
			
			ResultSet rs = ps.executeQuery();
			
			boolean flag = rs.next();
			if(flag) {
				while(flag) {
					System.out.println(ConsoleColors.CYAN+"Enter the Batch Id :"+ConsoleColors.RESET);
					String batchId = sc.next();
					
					BatchDao dao = new BatchDaoImpl();
					
					try {
						String res = dao.allocateFaculty(set, batchId);
						System.out.println();
						System.out.println(res);
						System.out.println();
						flag = false;
						
					} catch (BatchException e) {
						System.out.println();
						System.out.println(ConsoleColors.RED_BACKGROUND+ e.getMessage()+ConsoleColors.RESET);
						System.out.println();
						
					}
		
				}
				
			}else {
				System.out.println();
				System.out.println(ConsoleColors.RED+"Faculty is Not Present.."+ConsoleColors.RESET);
				System.out.println();
				allocateFaculty();
			}
			
		}catch(Exception ie) {
			System.out.println();
			System.out.println(ConsoleColors.RED+"Wrong Input Try Again!"+ConsoleColors.RESET);
			System.out.println();
			allocateFaculty();
		}
		
	}

}
