package com.masai.utility;

import java.sql.Connection;

public class Demo {
	
	public static void main(String[] args) {
		
		Connection conn = DBconn.provideConnection();
		
		System.out.println(conn);
		
	}
	
}
