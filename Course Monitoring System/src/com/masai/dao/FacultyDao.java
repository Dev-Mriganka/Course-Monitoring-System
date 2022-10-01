package com.masai.dao;

import java.util.List;

import com.masai.bean.Faculty;
import com.masai.exceptions.FacultyException;

public interface FacultyDao {
	
	public String addFaculty(Faculty faculty) throws FacultyException;
	
	public List<Faculty> getAllFacultyDetails()throws FacultyException;
	
	public List<Faculty> searchFacultyByName(String name) throws FacultyException;
	
	public Faculty searchFacultyById(int id) throws FacultyException;
	
	public String updateFacultyDetails(String str, String set, int id) throws FacultyException;
	
	public String deleteFaculty(int facultyId) throws FacultyException;
	
}
