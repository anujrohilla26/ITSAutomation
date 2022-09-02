package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {


	public String getCurrentDateTime(String format) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println("=====DATETIME==="+dtf.format(now) );
		return dtf.format(now);  
	}
	

	public String getCurrentDateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		return dtf.format(now);  
	}
}
