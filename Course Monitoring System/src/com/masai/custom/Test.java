package com.masai.custom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {
	public static void main(String[] args) {
		String dt = "2019-07-12";  // Start date

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar c = Calendar.getInstance();

		try {
			c.setTime(sdf.parse(dt));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		c.add(Calendar.DATE, 1);  // number of days to add

		dt = sdf.format(c.getTime());  // dt is now the new date
		
		System.out.println(dt);
	}
}
