package com.masai.facultyOptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.dao.FacultyOptionsDao;
import com.masai.dao.FacultyOptionsDaoImpl;
import com.masai.exceptions.FacultyOptionsException;
import com.masai.utility.DBconn;

public class ForgetPassword {
	
	public static boolean forgetPass() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		try(Connection conn = DBconn.provideConnection()){
			
			System.out.println(ConsoleColors.CYAN+"Enter Mobile No. : "+ConsoleColors.RESET);
			String mobile = sc.next();
			
			System.out.println(ConsoleColors.CYAN+"Enter Email No. : "+ConsoleColors.RESET);
			String email = sc.next();
			
			
			
			PreparedStatement ps = conn .prepareStatement("select * from faculty where mobile = ? and email = ?");
			ps.setString(1, mobile);
			ps.setString(2, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				FacultyOptionsDao dao = new FacultyOptionsDaoImpl();
					
				System.out.println(ConsoleColors.CYAN+"Enter New Password: "+ConsoleColors.RESET);
				String newPass = sc.next();
				
				
				System.out.println(ConsoleColors.CYAN+"Enter New Password Again : "+ConsoleColors.RESET);
				String newPass2 = sc.next();
				

				if(newPass.equals(newPass2)) {
					
					
					try {
						String res = dao.forgetPassword(mobile, email, newPass2);
						System.out.println();
						System.out.println(res);
						System.out.println();
						
					} catch (FacultyOptionsException e) {
						System.out.println();
						System.out.println(ConsoleColors.RED_BACKGROUND+ e.getMessage()+ConsoleColors.RESET);
						System.out.println();
						return false;
					}
					
				}else {
					System.out.println();
					System.out.println(ConsoleColors.RED+"New Password Mismatch.."+ConsoleColors.RESET);
					System.out.println();
					return false;
				}
				
				
			}else {
				System.out.println();
				System.out.println(ConsoleColors.RED+"Mobile Number or Email Not Found.."+ConsoleColors.RESET);
				System.out.println();
				return false;
				
			}
			
		} catch (SQLException e) {
			System.out.println();
			System.out.println(ConsoleColors.RED_BACKGROUND+ e.getMessage()+ConsoleColors.RESET);
			System.out.println();
			return false;
			
		}
		return true;
		
	}
	
}
