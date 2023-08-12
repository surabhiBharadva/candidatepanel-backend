package com.example.candidatepanelbackend.utils;

import java.util.Date;


import org.springframework.stereotype.Component;


@Component
public class ValidationsUtilsString {
	
	 public Boolean checkVeladationString(String value) {  
		 if(value.isEmpty() || value == null || value.trim().isEmpty()) {
			 return true;
		 }
	        return false;
	    }
	 public boolean checkVeladationDate(Date value) {
		 if(value == null) {
			 return true;
		 }
	        return false;
	 }
	 public boolean checkVeladationLong(Long value) {
		 if(value == null || value == 0) {
			 return true;
		 }
	        return false;
	 }
	

}
