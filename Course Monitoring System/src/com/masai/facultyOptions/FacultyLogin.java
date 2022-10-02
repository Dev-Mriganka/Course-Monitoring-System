package com.masai.facultyOptions;

import java.util.Scanner;

import com.masai.bean.Faculty;
import com.masai.custom.ConsoleColors;
import com.masai.dao.FacultyOptionsDao;
import com.masai.dao.FacultyOptionsDaoImpl;
import com.masai.exceptions.FacultyOptionsException;

public class FacultyLogin {
	
	public static void login() {
		Faculty faculty = null;
		
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int i=4;
		for(; i>=0; i--) {
			System.out.println(ConsoleColors.CYAN+"Enter Username:"+ConsoleColors.RESET);
			String uname = sc.next();
			
			System.out.println(ConsoleColors.CYAN+"Enter Password:"+ConsoleColors.RESET);
			String pass = sc.next();
			
			FacultyOptionsDao dao = new FacultyOptionsDaoImpl();
			
			try {
				faculty = dao.loginFaculty(uname, pass);
//				System.out.println(faculty);
				if(faculty == null) {
					
				}else {				
					System.out.println();
					System.out.println(ConsoleColors.PURPLE_BACKGROUND+" Welcome "+faculty.getFname()+" "+ConsoleColors.RESET);
					System.out.println();
					FacultyLoginOption.facultyOption(faculty);
					return;
				}
		 	
			}catch (FacultyOptionsException e) {
				System.out.println();
				System.out.println(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
				System.out.println();
				System.out.println(ConsoleColors.YELLOW+i+" Attempts Left.."+ConsoleColors.RESET);
				System.out.println();
				while(true) {
					System.out.println(ConsoleColors.CYAN+"1. Forget Password");
					System.out.println("2. Want to try again?");
					System.out.println("3. Exit"+ConsoleColors.RESET);
					
					String ch = sc.next();
					if(ch.equals("1")) {	
						boolean check = ForgetPassword.forgetPass();
						if(check)
							return;
						else
							break;
					}else if(ch.equals("2")) {	
						break;
					}else if(ch.equals("3")) {	
						return;
					}else {
						System.out.println();
						System.out.println(ConsoleColors.RED+"Wrong Input...!"+ConsoleColors.RESET);
						System.out.println();
					}
				}
				
			}
		}
		System.out.println();
		System.out.println(ConsoleColors.YELLOW+"Try After 5 minutes.."+ConsoleColors.RESET);
		System.out.println();
	}
		
}
