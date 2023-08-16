package com.example.candidatepanelbackend.utils;

import java.util.Date;


import org.springframework.stereotype.Component;


@Component
public final class ValidationsUtilsString {
	
	public static Boolean checkVeladationString(String value) {  
		 if(value.isEmpty() || value == null || value.trim().isEmpty()) {
			 return true;
		 }
	        return false;
	    }
	public static boolean checkVeladationDate(Date value) {
		 if(value == null) {
			 return true;
		 }
	        return false;
	 }
	public static boolean checkVeladationLong(Long value) {
		 if(value == null || value == 0) {
			 return true;
		 }
	        return false;
	 }
	

}
