package kodlamaio.hrms.business;


import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Controls {
	
	
	public static boolean checkEmail(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.matches()) {
			//System.out.println("check mail");
			return true;
		}else {
			
			return false;
		}
	}
	

}
