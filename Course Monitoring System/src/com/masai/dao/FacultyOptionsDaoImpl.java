package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.Faculty;
import com.masai.custom.ConsoleColors;
import com.masai.exceptions.FacultyOptionsException;
import com.masai.utility.DBconn;

public class FacultyOptionsDaoImpl implements FacultyOptionsDao{

	@Override
	public Faculty loginFaculty(String username, String password) throws FacultyOptionsException {
		
		Faculty faculty = null;
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select * from faculty where username = ?");			
			
			ps.setString(1, username);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {		
				
				PreparedStatement ps2 = conn.prepareStatement("select * from faculty where username = ? and password = ?");
				
				ps2.setString(1, username);
				ps2.setString(2, password);
				
				ResultSet  rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					int fid = rs.getInt("facultyId");
					String fname = rs.getString("facultyFname");
					String lname = rs.getString("facultyLname");
					String address = rs.getString("facultyAddress");
					String state = rs.getString("facultyState");
					String pin = rs.getString("facultyPin");
					String mobile = rs.getString("mobile");
					String email = rs.getString("email");
					String uname = rs.getString("username");
	
					faculty = new Faculty(fid,fname,lname,address,state,pin,mobile,email,uname);
				}else
					
					throw new FacultyOptionsException(ConsoleColors.RED+"Wrong Password"+ConsoleColors.RESET);
				
			}else
			
				throw new FacultyOptionsException(ConsoleColors.RED+"No Such Faculty Present With this Username"+ConsoleColors.RESET);
			
			
		} catch (SQLException e) {
			
			throw new FacultyOptionsException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
		}
		
		return faculty;
		
	}

	
	
	
	@Override
	public String forgetPassword(String mobile, String email, String pass) throws FacultyOptionsException {
		
		String message = ConsoleColors.RED+"Sorry Not Able To Change Password"+ConsoleColors.RESET;
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update faculty set password = ? where mobile = ? and email = ?");
			
			ps.setString(1, pass);
			ps.setString(3, email);
			ps.setString(2, mobile);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"Your Password Updated Successfully.."+ConsoleColors.RESET;	
			}
			
		}catch(SQLException e) {
			
			message = ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET;
			
		}
		
		return message;
		
	}

	
	
	
	@Override
	public String changePassword(int faculty, String pass) throws FacultyOptionsException {
		
		String message = ConsoleColors.RED+"Password Not Updated..."+ConsoleColors.RESET;
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update faculty set password = ? where facultyId = ? ");
			
			ps.setString(1, pass);
			ps.setInt(2, faculty);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"Your Password Updated Successfully.."+ConsoleColors.RESET;	
			}
			
		}catch(SQLException e) {
			
			message = ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET;
			
		}
		
		return message;
		
	}
	
	
	
}
