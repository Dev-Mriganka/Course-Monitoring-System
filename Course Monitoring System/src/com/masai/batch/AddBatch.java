package com.masai.batch;


import java.util.Scanner;


import com.masai.bean.Batch;
import com.masai.custom.ConsoleColors;
import com.masai.dao.BatchDao;
import com.masai.dao.BatchDaoImpl;
import com.masai.exceptions.BatchException;
import com.masai.exceptions.InputException;

public class AddBatch {
	

	public static void addBatchMtd() throws InputException{
		
		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println(ConsoleColors.CYAN+"Enter CourseId of the Batch"+ConsoleColors.RESET);
			int cId = sc.nextInt();
		
			System.out.println(ConsoleColors.CYAN+"Enter Students no. of the Batch"+ConsoleColors.RESET);
			int noStud = sc.nextInt();
			
			System.out.println(ConsoleColors.CYAN+"Enter Start date of the Batch(YYYY-MM-DD)."+ConsoleColors.RESET);
			String date = sc.next();
			
			sc.nextLine();
			System.out.println(ConsoleColors.CYAN+"Enter Batch Duration"+ConsoleColors.RESET);
			String bDur = sc.nextLine();
			
			
			Batch batch = new Batch(cId, noStud, date, bDur);
			
			BatchDao dao1 = new BatchDaoImpl();
			
			try {
				String str = dao1.addBatch(batch);
				System.out.println();
				System.out.println(str);
				System.out.println();
				
			} catch (BatchException e) {

				System.out.println();
				System.out.println(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
				System.out.println();
			}
			
		}catch(Exception e) {
			throw new InputException(ConsoleColors.RED+"Please Enter Right Input"+ConsoleColors.RESET);
		}
		
	}
}
