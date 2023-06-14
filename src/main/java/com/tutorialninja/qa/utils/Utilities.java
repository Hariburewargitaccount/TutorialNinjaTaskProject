package com.tutorialninja.qa.utils;

import java.util.Date;

//import java.sql.Date;
//import java.sql.Date;
//import java.util.sql;

public class Utilities {
	
	public static final int IMPLICIT_WAIT=20;
	public static final int IMPLICIT_LOAD=20;
	
	public static String genrateEmailTimeStamp() {
		
		Date date = new Date();
		String timestamp=date.toString().replace(" ","_").replace(" ","");
		return "har"+timestamp+"@gmail.com";
	}
	
	
	
}
