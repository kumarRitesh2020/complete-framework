package org_salesandinventory_genericutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;



import net.bytebuddy.dynamic.loading.InjectionClassLoader.Strategy;
import test.junit.testsetup.Data;

public class Javautility {
	/**
	 * 
	 * @param limit
	 * @return 
	 * @return
	 */
public  int getRandomNumber(int bound) 
{
	return new Random().nextInt(bound);
}
/**
 * 
 * @param value1
 * @param Strategy
 * @return
 * @throws NumberFormatException
 */
public Object converstringToanyDataType(String value, Datatype Strategy) throws NumberFormatException
{
	Object obj = null;
  if(Strategy.toString().equalsIgnoreCase("long"))
  {
	 obj=Long.parseLong(value);
	  
  }
   if(Strategy.toString().equalsIgnoreCase("int"))
   {
	  obj=Integer.parseInt(value);
	  
   }
   return obj;
}
/**
 * this method is used to convert integer to string
 * @param i
 * @return
 */
public Object  convertIntTostring(int i) 
{
	String value = Integer.toString(i);
	return value;
}
/**
 * this method used to dispaly system date
 */
public String getSystemData() 
{
	Data Data = new Data();
	return Data.toString();
	
}
 
public void toGiveCustomTimeAndClick( WebElement element) 
{
	int count=0;
	int duration=20;
	while(count<duration)
	{
		try {
			element.click();
			break;
			}
			catch(Exception e)
			{
				try {
					Thread.sleep(1000);			//polling time
				} 
				catch (InterruptedException e1) 
				{
					e1.printStackTrace();
				}
				count++;
			}
	}
}


public String toGiveCustomTimeAndAndClick( WebElement element1) 
{
	String text=null;
	int count1=0;
	int duration1=20;
	while(count1<duration1)
	{
		try {
			text = element1.getText();
			break;
			}
			catch(Exception e)
			{
				try {
					Thread.sleep(1000);			//polling time
				} 
				catch (InterruptedException e1) 
				{
					e1.printStackTrace();
				}
				count1++;
			}	
		}
		return text;
	}
	
public String currentTime()
{
	Date date= new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
	String actualDate = sdf.format(date);
	return actualDate;
	
}
}

