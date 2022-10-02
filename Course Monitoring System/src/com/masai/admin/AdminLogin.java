package com.masai.admin;

import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exceptions.AdminException;

public class AdminLogin {
	
	public static void LoginAdmin(){
		
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int i=4;
		for(; i>=0; i--) {
			
			System.out.println(ConsoleColors.CYAN+"Enter Username:"+ConsoleColors.RESET);
			String uname = sc.next();
			
			System.out.println(ConsoleColors.CYAN+"Enter Password:"+ConsoleColors.RESET);
			String pass = sc.next();
			
			AdminDao dao = new AdminDaoImpl();
			
			try {
				boolean flag = dao.LoginAdmin(uname, pass);
				if(flag) {
					AdminChoice.adminOption();
					return;
				}
		 	
			}catch (AdminException e) {
				System.out.println();
				System.out.println(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
				System.out.println();
				System.out.println(ConsoleColors.YELLOW+i+" Attempts Left.."+ConsoleColors.RESET);
				System.out.println();
				while(true) {
					System.out.println(ConsoleColors.CYAN+"Want to try again?(y/n)"+ConsoleColors.RESET);
					String choice = sc.next();
					
					if(choice.equalsIgnoreCase("y")) {
						break;
					}else if(choice.equalsIgnoreCase("n")){
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
