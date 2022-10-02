package com.masai.dao;

import com.masai.bean.Faculty;
import com.masai.exceptions.FacultyOptionsException;

public interface FacultyOptionsDao {
	public Faculty loginFaculty(String username, String password) throws FacultyOptionsException;
	
	public String forgetPassword(String mobile, String email, String pass) throws FacultyOptionsException;
	
	public String changePassword(int faculty, String pass) throws FacultyOptionsException;
}
