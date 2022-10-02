package com.masai.Main;

import java.util.Scanner;

import com.masai.admin.AdminLogin;
import com.masai.custom.ConsoleColors;
import com.masai.facultyOptions.FacultyLogin;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println(ConsoleColors.DARK_RED_BACKGROUND+" Course Monitoring System"+" "+ConsoleColors.RESET);
		System.out.println();

		Scanner sc = new Scanner(System.in);
			
		while(true) {
				
			System.out.println(ConsoleColors.CYAN+"1. Admin Login");
			System.out.println("2. Faculty Login");
			System.out.println("3. Close"+ConsoleColors.RESET);
				
			String ch = sc.next();
				
			if(ch.equals("1")) {			
				AdminLogin.LoginAdmin();
					
			}else if(ch.equals("2")) {		
				FacultyLogin.login();
				
			}else if(ch.equals("3")) {
				System.out.println();
				System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"See You Soon..."+ConsoleColors.RESET);
				break;
					
			}else {
				System.out.println();
				System.out.println(ConsoleColors.RED+"Wrong Input Try Again!"+ConsoleColors.RESET);
				System.out.println();
				
			}
			
		}
		sc.close();
		
	}
	
}
