package com.masai.dao;

import com.masai.exceptions.AdminException;

public interface AdminDao {
	public boolean LoginAdmin(String username , String password) throws AdminException;
	
}
