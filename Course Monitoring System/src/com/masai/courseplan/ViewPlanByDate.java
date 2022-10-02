package com.masai.courseplan;

import java.util.List;

import com.masai.bean.CoursePlan;
import com.masai.custom.ConsoleColors;
import com.masai.dao.CourseplanDao;
import com.masai.dao.CourseplanDaoImpl;
import com.masai.exceptions.CoursePlanException;

public class ViewPlanByDate {
	
public static void viewAllPlan(String date) {
		
		CourseplanDao dao = new CourseplanDaoImpl();
		
		try {
			List<CoursePlan> plans = dao.viewCourseByDate(date);

			System.out.println();
			System.out.println(ConsoleColors.ORANGE+"--------------------------------------------------------------------------");
			System.out.printf("%8s %10s %6s %20s %10s %10s", " PLAN ID |", "BATCH ID |", "DAY NO |", "TOPIC |", "PLAN DATE |", "STATUS |");
			System.out.println();
			System.out.println("--------------------------------------------------------------------------");
			
			plans.forEach(e -> {
				System.out.printf("%5s %13s %6s %20s %14s %8s", e.getPlanId(), e.getBatchId(), e.getDaynumber(), e.getTopic(), e.getDate(), e.isStatus());
				System.out.println();
				
			});
			System.out.println();
			
		} catch (CoursePlanException e) {
			System.out.println();
			System.out.println(ConsoleColors.RED_BACKGROUND+ e.getMessage()+ConsoleColors.RESET);
			System.out.println();
			
		}
		
	}
	
}
