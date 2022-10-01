package com.masai.courseplan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.custom.ConsoleColors;
import com.masai.utility.DBconn;

public class CheckFacultyId {
	
	public static boolean checkFacultyId(int facultyId) {
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("select * from faculty where facultyId = ?");
			ps.setInt(1, facultyId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND+ e.getMessage()+ConsoleColors.RESET);
			
		}
		
		return false;
	}
	
}
