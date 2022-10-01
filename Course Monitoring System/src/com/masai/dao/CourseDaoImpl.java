package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Course;
import com.masai.custom.ConsoleColors;
import com.masai.exceptions.CourseException;
import com.masai.utility.DBconn;

public class CourseDaoImpl implements CourseDao{
	
	
	// Add New Course into Database
	@Override
	public String addCourse(Course course) throws CourseException{
		
		String message = ConsoleColors.RED+"Data Not Inserted..."+ConsoleColors.RESET;
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("insert into course(courseName, courseFee, courseDesc) values(?,?,?)");
			
			ps.setString(1, course.getCourseName());
			ps.setInt(2, course.getCourseFee());
			ps.setString(3, course.getCourseDesc());
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"New Course Added Successfully.."+ConsoleColors.RESET;	
			}else {
				throw new CourseException(ConsoleColors.RED_BACKGROUND+"Duplicate Entry"+ConsoleColors.RESET);
			}
			
		}catch(SQLException e) {
//			e.printStackTrace();
			
			throw new CourseException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
		
		return message;
	}
	
	
	// Search Course With Name
	@Override
	public Course searchCourse(String name) throws CourseException{
		
		Course course = null;
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("Select * from Course where courseName = ?");
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {		
				
				int cid = rs.getInt("courseId");
				String cname = rs.getString("courseName");
				int cfee = rs.getInt("courseFee");
				String cdesc = rs.getString("courseDesc");
				
				course = new Course(cid, cname, cfee, cdesc);
				
			}else {
				throw new CourseException(ConsoleColors.RED_BACKGROUND+"Course does not exist."+ConsoleColors.RESET);
			}
			
				
		}catch(SQLException e) {
//			e.printStackTrace();
			
			throw new CourseException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
		}
		
		return course;
	}


	// See All Course Details Present in Database
	@Override
	public List<Course> getAllCourse() throws CourseException {
		
		List<Course> courses = new ArrayList<>();
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("Select * from Course");

			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {		
				
				int cid = rs.getInt("courseId");
				String cname = rs.getString("courseName");
				int cfee = rs.getInt("courseFee");
				String cdesc = rs.getString("courseDesc");
				
				Course course = new Course(cid, cname, cfee, cdesc);
				
				courses.add(course);
				
			}
			
			if(courses.size() == 0) {
				throw new CourseException(ConsoleColors.RED_BACKGROUND+"No Course found.."+ConsoleColors.RESET);
			}
			
				
		}catch(SQLException e) {
//			e.printStackTrace();
			
			throw new CourseException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
		}
		
		return courses;
	}

	
	// Update details of Course table
	@Override
	public String updateCourseDetails(String str, String set, String name) throws CourseException{
		
		String message = ConsoleColors.RED+"Course Data Not Updated..."+ConsoleColors.RESET;
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update course set "+ str +" = ? where courseName = ?");
			
			ps.setString(1, set);
			ps.setString(2, name);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"course Details Updated Successfully.."+ConsoleColors.RESET;	
			}else {
				throw new CourseException(ConsoleColors.RED+"Course Not Exist"+ConsoleColors.RESET);
			}
			
		} catch (SQLException e) {	
			throw new CourseException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
		
		return message;
	}


	// Delete details from Course table
	@Override
	public String deleteBatch(String cName) throws CourseException {

		String message = ConsoleColors.RED+"Batch Data Not Updated..."+ConsoleColors.RESET;
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from course where courseName = ?");
			
			ps.setString(1, cName);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"Course Deleted Successfully.."+ConsoleColors.RESET;	
			}else {
				throw new CourseException(ConsoleColors.RED+"Course Not Exist"+ConsoleColors.RESET);
				
			}
		}catch (SQLException e) {
			
			throw new CourseException(ConsoleColors.RED+"Wrong Data Format"+ConsoleColors.RESET);
		}
		
		return message;
		
	}

	
}


