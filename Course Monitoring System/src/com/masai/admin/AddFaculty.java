package com.masai.admin;

import java.util.Scanner;

import com.masai.bean.Faculty;
import com.masai.dao.FacultyDao;
import com.masai.dao.FacultyDaoImpl;

public class AddFaculty {
	
	public static void addFacultyMtd() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter First Name of Faculty");
		String fname = sc.next();
		
		System.out.println("Enter Last Name of Faculty");
		String lname = sc.next();
		
		sc.nextLine();
		System.out.println("Enter Faculty Address");
		String address = sc.nextLine();
		
		System.out.println("Enter Faculty State(Short Form)");
		String state = sc.next();
		
		System.out.println("Enter Faculty Pincode");
		String pin = sc.next();
		
		System.out.println("Enter Faculty Mobile No.");
		String mobile = sc.next();
		
		System.out.println("Enter Faculty Email");
		String email = sc.next();
		
		
		Faculty faculty = new Faculty(fname, lname, address, state, pin, mobile, email);
		
		FacultyDao dao = new FacultyDaoImpl();
		
		String result = dao.addFaculty(faculty);
		
		System.out.println("--------------------");
		System.out.println(result);
		
		
	}
	
}
