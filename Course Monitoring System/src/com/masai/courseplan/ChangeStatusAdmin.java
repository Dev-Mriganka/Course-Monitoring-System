package com.masai.courseplan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.dao.CourseplanDao;
import com.masai.dao.CourseplanDaoImpl;
import com.masai.exceptions.CoursePlanException;
import com.masai.utility.DBconn;

public class ChangeStatusAdmin {
	
public static void changeStatusAdmin(int facultyId) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("select batchId from batch where facultyId = ?");
			
			ps.setInt(1, facultyId);
			
			ResultSet rs = ps.executeQuery();
			List<String> arr = new ArrayList<>();
			while(rs.next()) {
				arr.add(rs.getString("batchId"));
			}
			
			if(arr.size()==0) {
				System.out.println(ConsoleColors.YELLOW+facultyId + "is not Allocated to Any Batch"+ConsoleColors.RESET);
				return;
			}
			
			System.out.println(ConsoleColors.CYAN+"Choose Batch Id :"+ConsoleColors.RESET);
			for(int i = 0; i < arr.size(); i++) {
				System.out.println((i+1)+". " +arr.get(i));
			}
			
			int ch = sc.nextInt();
			String batchId = arr.get(ch-1);
			
			System.out.println(ConsoleColors.CYAN+"Enter the day no : "+ConsoleColors.RESET);
			
			int dayNo = sc.nextInt();
			
			CourseplanDao dao = new CourseplanDaoImpl();
			
			try {
				String res = dao.updateStatusAdmin(batchId, dayNo);
				System.out.println();
				System.out.println(res);
				System.out.println();
				
			} catch (CoursePlanException e) {
				System.out.println();
				System.out.println(ConsoleColors.RED_BACKGROUND+ e.getMessage()+ConsoleColors.RESET);
				System.out.println();
				
			}
			
		}catch (Exception e) {
			System.out.println();
			System.out.println(ConsoleColors.RED+"Please Enter Right Input"+ConsoleColors.RESET);
			System.out.println();
			changeStatusAdmin(facultyId);
		}
		
	}
	
}
