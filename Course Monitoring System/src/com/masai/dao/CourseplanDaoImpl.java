package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.masai.bean.CoursePlan;
import com.masai.custom.ConsoleColors;
import com.masai.exceptions.CoursePlanException;
import com.masai.utility.DBconn;

public class CourseplanDaoImpl implements CourseplanDao{
	
	
	// Add New Course Plan into Database
	@Override
	public String addCoursePlan(String batchId, int dayNo) throws CoursePlanException {
		
		String message = ConsoleColors.RED+"Data Not Inserted..."+ConsoleColors.RESET;
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps1 = conn .prepareStatement("select batchstartDate from batch where batchId = ?");
			
			ps1.setString(1, batchId);
			ResultSet rs = ps1.executeQuery();
			
			String dt = "";
			
			if(rs.next()) {
				Date date = rs.getDate("batchstartDate");
				dt = date.toString();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				Calendar c = Calendar.getInstance();

				try {
					c.setTime(sdf.parse(dt));
					
				} catch (ParseException e) {				
					System.out.println((ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET));
					
				}
				c.add(Calendar.DATE, dayNo-1);  // number of days to add

				dt = sdf.format(c.getTime());  // dt is now the new date
			}
			
			PreparedStatement ps = conn .prepareStatement("insert into courseplan(batchId, daynumber, planDate) values(?, ?, ?)");
			
			ps.setString(1, batchId);
			ps.setInt(2, dayNo);
			ps.setString(3, dt);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"New Course Plan Added Successfully.."+ConsoleColors.RESET;	
			}
		}catch(SQLException e) {
			throw new CoursePlanException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
		}
		
		return message;
	}
	
	
	// Update Status of Course table for Faculty Only
	@Override
	public String updateStatus(String batchId, int dayNo) throws CoursePlanException {
		
		String message = ConsoleColors.RED+"Status Not Updated..."+ConsoleColors.RESET;
		
		try(Connection conn = DBconn.provideConnection()){
			PreparedStatement ps1 = conn .prepareStatement("select datediff(planDate,curdate()) as date from courseplan where batchId = ? AND daynumber = ?");
			
			ps1.setString(1, batchId);
			ps1.setInt(2, dayNo);
			
			ResultSet rs = ps1.executeQuery();
			
			int diff =-1;
			if(rs.next()) {
				diff = rs.getInt(1);
			}
			
			if(diff<=0) {
				PreparedStatement ps = conn .prepareStatement("update courseplan set status = true where batchId = ? AND daynumber = ?");
				
				ps.setString(1, batchId);
				ps.setInt(2, dayNo);
				
				int x = ps.executeUpdate();
				
				if(x>0) {		
					message = ConsoleColors.GREEN+"Status Updated Successfully.."+ConsoleColors.RESET;	
				}else {
					throw new CoursePlanException(ConsoleColors.RED+"Day no "+dayNo+" is not Planned yet.."+ConsoleColors.RESET);
				}
			}else {
				throw new CoursePlanException(ConsoleColors.RED+"You Can't Change Status For a Future Date"+ConsoleColors.RESET);
			}
			
		}catch(Exception e) {
			throw new CoursePlanException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
		}
		
		return message;
	}
	
	
	// Update topic of Course table for Faculty Only
	@Override
	public String updateTopic(String batchId, int dayNo, String topic) throws CoursePlanException {
			
		String message = ConsoleColors.RED+"Status Not Updated..."+ConsoleColors.RESET;
			
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("update courseplan set topic = ? where batchId = ? AND daynumber = ?");
				
			ps.setString(1, topic);
			ps.setString(2, batchId);
			ps.setInt(3, dayNo);
				
			int x = ps.executeUpdate();
				
			if(x>0) {		
				message = ConsoleColors.GREEN+"Status Updated Successfully.."+ConsoleColors.RESET;	
				
			}else {
				throw new CoursePlanException(ConsoleColors.RED+"Day no "+dayNo+" is not Planned yet.."+ConsoleColors.RESET);
				
			}
			
		}catch(SQLException e) {
			throw new CoursePlanException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
			
		return message;
	}
	
	
	// Delete Day plan from Course table
	@Override
	public String deleteStatus(String batchId, int dayNo) throws CoursePlanException {
		
		String message = ConsoleColors.RED+"Plan Not Deleted..."+ConsoleColors.RESET;
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("delete from courseplan where batchId = ? AND daynumber = ?");
			
			ps.setString(1, batchId);
			ps.setInt(2, dayNo);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"Course Plan Deleted Successfully.."+ConsoleColors.RESET;	
				
			}else {
				throw new CoursePlanException(ConsoleColors.RED+"Day no "+dayNo+" is not Planned yet.."+ConsoleColors.RESET);
				
			}
			
		}catch(SQLException e) {
			throw new CoursePlanException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
		}
		
		return message;
		
	}

	
	// View All Plans Date Wise
	@Override
	public List<CoursePlan> viewAllCoursePlanDateWise() throws CoursePlanException {
		
		List<CoursePlan> coursePlans = new ArrayList<>();
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("SELECT * FROM courseplan ORDER BY planDate");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {		
				
				int pid = rs.getInt("planId");
				String bid = rs.getString("batchId");
				int dNo = rs.getInt("daynumber");
				String topic = rs.getString("topic");
				Date date = rs.getDate("planDate");
				boolean staus = rs.getBoolean("status");
				
				String dt = date.toString();
				
				CoursePlan course = new CoursePlan(pid, bid, dNo, topic, dt, staus);
				
				coursePlans.add(course);
				
			}
			
			if(coursePlans.size() == 0)
				throw new CoursePlanException(ConsoleColors.RED_BACKGROUND+"No Plan is Created till Now.."+ConsoleColors.RESET);
			
		}catch(SQLException e) {
			throw new CoursePlanException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
		
		return coursePlans;
	}
	
	
	// View Plans As Per Faculty
	@Override
	public List<CoursePlan> viewFacultyCoursePlan(int facultyId) throws CoursePlanException{
		
		List<CoursePlan> coursePlans = new ArrayList<>();
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select c.* from Courseplan c, Batch b where c.batchId = b.batchId and b.facultyId = ? ORDER BY planDate");
			
			ps.setInt(1, facultyId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {		
				
				int pid = rs.getInt("planId");
				String bid = rs.getString("batchId");
				int dNo = rs.getInt("daynumber");
				String topic = rs.getString("topic");
				Date date = rs.getDate("planDate");
				boolean staus = rs.getBoolean("status");
				
				String dt = date.toString();
				
				CoursePlan course = new CoursePlan(pid, bid, dNo, topic, dt, staus);
				
				coursePlans.add(course);
				
			}
			
			if(coursePlans.size() == 0)
				throw new CoursePlanException(ConsoleColors.RED_BACKGROUND+"No Such Plan.."+ConsoleColors.RESET);
			
		}catch(SQLException e) {
			throw new CoursePlanException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
		
		return coursePlans;
		
	}

	
	// Update Date of Course table
	@Override
	public String updateDate(String batchId, int dayNo, int newDay) throws CoursePlanException {
		
		
		String message = ConsoleColors.RED+"Status Not Updated..."+ConsoleColors.RESET;
		
		try(Connection conn = DBconn.provideConnection()){
				
			PreparedStatement ps1 = conn .prepareStatement("select batchstartDate from batch where batchId = ?");
			
			ps1.setString(1, batchId);
			ResultSet rs = ps1.executeQuery();
			
			String dt = "";
			
			if(rs.next()) {
				Date date = rs.getDate("batchstartDate");
				dt = date.toString();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				Calendar c = Calendar.getInstance();

				try {
					c.setTime(sdf.parse(dt));
					
				} catch (ParseException e) {				
					System.out.println((ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET));
					
				}
				c.add(Calendar.DATE, newDay-1);  // number of days to add

				dt = sdf.format(c.getTime());  // dt is now the new date
			}
			
			
			PreparedStatement ps = conn.prepareStatement("update courseplan set daynumber = ? where batchId = ? AND daynumber = ?");

			ps.setInt(1, newDay);
			ps.setString(2, batchId);
			ps.setInt(3, dayNo);
				
			int x = ps.executeUpdate();
				
			if(x>0) {		
				
				PreparedStatement ps3 = conn.prepareStatement("update courseplan set planDate = ? where batchId = ? AND daynumber = ?");

				
				ps3.setString(1, dt);
				ps3.setString(2, batchId);
				ps3.setInt(3, newDay);
				
				int y = ps3.executeUpdate();
				
				if(y>0)
					message = ConsoleColors.GREEN+"Status Updated Successfully.."+ConsoleColors.RESET;	
				else 
					throw new CoursePlanException(ConsoleColors.RED+"Day no "+dayNo+" is not Planned yet.."+ConsoleColors.RESET);
			
				
			}else {
				throw new CoursePlanException(ConsoleColors.RED+"Day no "+dayNo+" is not Planned yet.."+ConsoleColors.RESET);
				
			}
			
		}catch(SQLException e) {
			throw new CoursePlanException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
			
		return message;
	}

	
	// View Plans By Date
	@Override
	public List<CoursePlan> viewCourseByDate(String date) throws CoursePlanException {
		
		List<CoursePlan> coursePlans = new ArrayList<>();
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from courseplan where planDate = ? ");
			
			ps.setString(1, date);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {		
				
				int pid = rs.getInt("planId");
				String bid = rs.getString("batchId");
				int dNo = rs.getInt("daynumber");
				String topic = rs.getString("topic");
				Date rdate = rs.getDate("planDate");
				boolean staus = rs.getBoolean("status");
				
				String dt = rdate.toString();
				
				CoursePlan course = new CoursePlan(pid, bid, dNo, topic, dt, staus);
				
				coursePlans.add(course);
				
			}
			
			if(coursePlans.size() == 0)
				throw new CoursePlanException(ConsoleColors.RED_BACKGROUND+"No Plan for this Date"+ConsoleColors.RESET);
			
		}catch(SQLException e) {
			throw new CoursePlanException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
		
		return coursePlans;
	}


	
	
	// Update Status of Course table
	@Override
	public String updateStatusAdmin(String batchId, int dayNo) throws CoursePlanException {
		
		String message = ConsoleColors.RED+"Status Not Updated..."+ConsoleColors.RESET;
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("update courseplan set status = false where batchId = ? AND daynumber = ?");
			
			ps.setString(1, batchId);
			ps.setInt(2, dayNo);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"Status Updated Successfully.."+ConsoleColors.RESET;	
			}else {
				throw new CoursePlanException(ConsoleColors.RED+"Day no "+dayNo+" is not Planned yet.."+ConsoleColors.RESET);
			}
		}catch(Exception e) {
			throw new CoursePlanException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
		}
		
		return message;
		
	}
	
}
