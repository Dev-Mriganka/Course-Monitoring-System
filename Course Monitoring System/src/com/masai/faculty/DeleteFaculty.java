package com.masai.faculty;

import java.util.Scanner;

import com.masai.custom.ConsoleColors;

import com.masai.dao.FacultyDao;
import com.masai.dao.FacultyDaoImpl;
import com.masai.exceptions.FacultyException;
import com.masai.exceptions.InputException;

public class DeleteFaculty {
	
public static void deleteFaculty() throws InputException {
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println(ConsoleColors.CYAN+"Enter id of Faculty"+ConsoleColors.RESET);
			int id = sc.nextInt();
			
			FacultyDao dao = new FacultyDaoImpl();
			
			try {
				String res = dao.deleteFaculty(id);
				System.out.println();
				System.out.println(res);
				System.out.println();
				
			} catch (FacultyException e) {
				System.out.println();
				System.out.println(ConsoleColors.RED_BACKGROUND+ e.getMessage()+ConsoleColors.RESET);
				System.out.println();
				
			}
			
		}catch(Exception e) {
			throw new InputException(ConsoleColors.RED+"Please Enter Right Input"+ConsoleColors.RESET);
			
		}
	}
	
}
