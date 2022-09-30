package com.masai.admin;

import java.util.Scanner;

import com.masai.bean.Faculty;
import com.masai.custom.ConsoleColors;
import com.masai.dao.FacultyDao;
import com.masai.dao.FacultyDaoImpl;

public class AddFaculty {
	
	public static void addFacultyMtd() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColors.CYAN+"Enter First Name of Faculty"+ConsoleColors.RESET);
		String fname = sc.next();
		
		System.out.println(ConsoleColors.CYAN+"Enter Last Name of Faculty"+ConsoleColors.RESET);
		String lname = sc.next();
		
		sc.nextLine();
		System.out.println(ConsoleColors.CYAN+"Enter Faculty Address"+ConsoleColors.RESET);
		String address = sc.nextLine();
		
		System.out.println(ConsoleColors.CYAN+"Enter Faculty State(Short Form)"+ConsoleColors.RESET);
		String state = sc.next();
		
		System.out.println(ConsoleColors.CYAN+"Enter Faculty Pincode"+ConsoleColors.RESET);
		String pin = sc.next();
		
		System.out.println(ConsoleColors.CYAN+"Enter Faculty Mobile No."+ConsoleColors.RESET);
		String mobile = sc.next();
		
		System.out.println(ConsoleColors.CYAN+"Enter Faculty Email"+ConsoleColors.RESET);
		String email = sc.next();
		
		
		Faculty faculty = new Faculty(fname, lname, address, state, pin, mobile, email);
		
		FacultyDao dao = new FacultyDaoImpl();
		
		String result = dao.addFaculty(faculty);
		
		System.out.println("--------------------");
		System.out.println(result);
		
		
	}
	
}
