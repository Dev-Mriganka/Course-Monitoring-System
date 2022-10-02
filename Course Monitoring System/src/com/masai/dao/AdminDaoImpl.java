package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.custom.ConsoleColors;
import com.masai.exceptions.AdminException;
import com.masai.utility.DBconn;

public class AdminDaoImpl implements AdminDao{

	@Override
	public boolean LoginAdmin(String username, String password) throws AdminException {

		boolean flag  = false ;
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from admin where username = ?");
			
			ps.setString(1, username);
			
			
			ResultSet  rs = ps.executeQuery();
			
			if(rs.next()) {
		
				PreparedStatement ps2 = conn.prepareStatement("select * from admin where username = ? and password = ?");
				
				ps2.setString(1, username);
				ps2.setString(2, password);
				
				ResultSet  rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					flag = true ; 
				}
				else 
					throw new AdminException(ConsoleColors.RED+"Wrong Password"+ConsoleColors.RESET);
					
			}else {
				throw new AdminException(ConsoleColors.RED+"No Such Admin Present With this Username"+ConsoleColors.RESET);
				
			}
			
		} catch (SQLException e) {		
			throw new AdminException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
		
		return flag ; 
		
	}

}
