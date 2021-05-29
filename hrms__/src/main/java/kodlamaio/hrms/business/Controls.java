package kodlamaio.hrms.business;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.entities.concretes.Employer;



public class Controls {
	
	
	public static boolean checkEmailForEmployer(String website,Employer employer) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@"+ employer.getWebsite();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(website);
		
		if(matcher.matches()) {
			//System.out.println("check mail");
			return true;
		}else {
			new ErrorResult("Geçersiz Email.");
			return false;
		}
	}
	
	public static boolean checkEmailForCandidate(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.matches()) {
			//System.out.println("check mail");
			return true;
		}else {
			new ErrorResult("Geçersiz Email.");
			return false;
		}
	}
	

}
