package org_salesandinventory_genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementaion  implements IRetryAnalyzer
{
	int count=0;
	int maxRetries=3;
	
	@Override
	public boolean retry(ITestResult result) 
	{
		if(count<maxRetries)
		{
			count++;
			
		}
		
		return false;
	}

}
