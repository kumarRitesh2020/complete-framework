package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author User
 *
 */
public class JavaUtility {
	/**
	 * @return 
	 * 
	 */
public int getRandomNumber(int limit) {
	return new Random().nextInt(limit);
}
/**
 * This method is used to convert string to any data type based on strategy
 * @return 
 * @return 
 * 
 * 
 */
public Object convertStringtoAnyDatatype(String data,DataType strategy) {
	Object obj=null;
	if(strategy.toString().equalsIgnoreCase("long")) {
		obj=Long.parseLong(data);
	}
	
	else if(strategy.toString().equalsIgnoreCase("int")) {
		obj=Integer.parseInt(data);
	}
	
	else if(strategy.toString().equalsIgnoreCase("double")) {
		obj=Double.parseDouble(data);
	}
	return obj;
}
/**
 * This method is used to convert the current date and time into "dd_MM_yyyy_hh_mm_sss" format
 */
public String currentTime() {
	Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
	String actualDate=sdf.format(date);
	return actualDate;
}
}
